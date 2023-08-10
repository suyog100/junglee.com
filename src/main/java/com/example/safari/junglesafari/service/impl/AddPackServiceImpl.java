package com.example.safari.junglesafari.service.impl;

import com.example.safari.junglesafari.Pojo.AddPackPojo;
import com.example.safari.junglesafari.entity.AddPack;
import com.example.safari.junglesafari.repository.AddPackRepo;
import com.example.safari.junglesafari.service.AddPackService;
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
public class AddPackServiceImpl implements AddPackService {

    private final AddPackRepo addPackRepo;
    private final String UPLOAD_DIRECTORY=System.getProperty("user.dir")+"/file_server";
    @Override
    public void saveData(AddPackPojo addPackPojo) throws IOException {
        AddPack addPack = new AddPack();
        addPack.setId(addPackPojo.getId());
        addPack.setPack_description(addPackPojo.getPack_description());

        if(addPackPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, addPackPojo.getImage().getOriginalFilename());
            fileNames.append(addPackPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, addPackPojo.getImage().getBytes());

            addPack.setImage(addPackPojo.getImage().getOriginalFilename());
        }
        addPackRepo.save(addPack);
    }

    @Override
    public List<AddPack> getData() {
        return addPackRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        addPackRepo.deleteById(id);
    }

    @Override
    public Optional<AddPack> getById(Integer id) {
        return addPackRepo.findById(id);
    }

    @Override
    public void dropById(Integer id) {
        addPackRepo.deleteById(id);
    }

    @Override
    public List<AddPack> getAllData() {
        return addPackRepo.findAll();
    }

    @Override
    public Optional<AddPack> fetchById(Integer id) {
        return addPackRepo.findById(id);    }

    @Override
    public AddPack getByIdNotOpt(Integer id) {
        return addPackRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
}
