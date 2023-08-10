package com.example.safari.junglesafari.service;

import com.example.safari.junglesafari.Pojo.AddPackPojo;
import com.example.safari.junglesafari.entity.AddPack;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AddPackService {
    void saveData (AddPackPojo addPackPojo) throws IOException;

    List<AddPack> getData();

    void deleteById(Integer id);

    Optional<AddPack> getById(Integer id);

    void dropById(Integer id);

    List<AddPack> getAllData();

    Optional<AddPack> fetchById(Integer id);

    AddPack getByIdNotOpt(Integer id);
}
