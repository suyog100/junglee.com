package com.example.safari.junglesafari.service;
import com.example.safari.junglesafari.Pojo.AdminPagePojo;
import com.example.safari.junglesafari.entity.AdminPage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AdminPageService {
    void saveData (AdminPagePojo adminPagePojo) throws IOException;

    List<AdminPage> getData();

    void deleteById(Integer id);

    Optional<AdminPage> getById(Integer id);


    List<AdminPage> getAllData();

    Optional<AdminPage> fetchById(Integer id);

    AdminPage getByIdNotOpt(Integer id);
}
