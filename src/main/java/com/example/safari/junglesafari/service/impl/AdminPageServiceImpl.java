package com.example.safari.junglesafari.service.impl;
import com.example.safari.junglesafari.Pojo.AdminPagePojo;
import com.example.safari.junglesafari.entity.AdminPage;
import com.example.safari.junglesafari.repository.AdminPageRepo;
import com.example.safari.junglesafari.service.AdminPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminPageServiceImpl implements AdminPageService {
    private final AdminPageRepo adminPageRepo;
    @Override
    public void saveData(AdminPagePojo adminPagePojo) throws IOException {
        AdminPage adminPage = new AdminPage();
        adminPage.setId(adminPagePojo.getId());
        adminPage.setFullname(adminPagePojo.getFullname());
        adminPage.setEmail(adminPagePojo.getEmail());
        adminPage.setContact_number(adminPagePojo.getContact_number());
        adminPage.setPackageNo(adminPagePojo.getPackageNo());
        adminPageRepo.save(adminPage);

    }

    @Override
    public List<AdminPage> getData() {
        return adminPageRepo.findAll();
    }
    @Override
    public void deleteById(Integer id) {
        adminPageRepo.deleteById(id);
    }

    @Override
    public Optional<AdminPage> getById(Integer id) {
        return adminPageRepo.findById(id);
    }


    @Override
    public List<AdminPage> getAllData() {
        return adminPageRepo.findAll();
    }

    @Override
    public Optional<AdminPage> fetchById(Integer id) {
        return adminPageRepo.findById(id);
    }

    @Override
    public AdminPage getByIdNotOpt(Integer id) {
        return adminPageRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
}
