package com.example.safari.junglesafari.service.impl;
import com.example.safari.junglesafari.Pojo.UserPojo;
import com.example.safari.junglesafari.config.PasswordEncoderUtil;
import com.example.safari.junglesafari.entity.User;
import com.example.safari.junglesafari.repository.UserRepo;
import com.example.safari.junglesafari.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;

import java.util.List;

import java.util.Optional;



@Service

@RequiredArgsConstructor

public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;


    private final String UPLOAD_DIRECTORY=System.getProperty("user.dir")+"/photo_file";

    @Override

    public UserPojo save(UserPojo userPojo) throws IOException {

        User user= new User();

        user.setId(userPojo.getId());

        user.setEmail(userPojo.getEmail());

        user.setFullName(userPojo.getFullName());

//        user.setMobileNo(userPojo.getMobile_no());

        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));


// if(userPojo.getImage()!=null){

// StringBuilder fileNames = new StringBuilder();

// System.out.println(UPLOAD_DIRECTORY);

// Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, userPojo.getImage().getOriginalFilename());

// fileNames.append(userPojo.getImage().getOriginalFilename());

// Files.write(fileNameAndPath, userPojo.getImage().getBytes());

//

// user.setImage(userPojo.getImage().getOriginalFilename());

// }


        User savedUser= userRepo.save(user);

        return new UserPojo(savedUser);

    }


    @Override

    public List<User> fetchAll() {

        return userRepo.findAll();

    }


    @Override

    public Optional<User> fetchById(Integer id) {

        return userRepo.findById(id);

    }


    @Override

    public void deleteById(Integer id) {

        userRepo.deleteById(id);

    }


    @Override

    public void sendEmail() {


    }


    @Override

    public User fatchByEmail(String email) {

        return userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Not Found"));

    }


    @Override

    public void update(UserPojo userPojo) throws IOException {

        User user= userRepo.findById(userPojo.getId()).get();

        user.setId(userPojo.getId());

        user.setEmail(userPojo.getEmail());

        user.setFullName(userPojo.getFullName());

//        user.setMobileNo(userPojo.getMobile_no());

        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));


        if(userPojo.getImage()!=null){

            StringBuilder fileNames = new StringBuilder();

            System.out.println(UPLOAD_DIRECTORY);

            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, userPojo.getImage().getOriginalFilename());

            fileNames.append(userPojo.getImage().getOriginalFilename());

            Files.write(fileNameAndPath, userPojo.getImage().getBytes());

            user.setImage(userPojo.getImage().getOriginalFilename());
        }


        userRepo.save(user);

    }

}
