package com.example.safari.junglesafari.controller;


import com.example.safari.junglesafari.Pojo.AddPackPojo;
import com.example.safari.junglesafari.entity.AddPack;
import com.example.safari.junglesafari.service.AddPackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Controller
@RequestMapping("/th-add")
@RequiredArgsConstructor
public class ThymeleafAddPackController {
    private final AddPackService addPackService;

    @GetMapping("/create")
    public String getFormPage(Model model) {
        model.addAttribute("addPackPojo", new AddPackPojo());
        model.addAttribute("packs", addPackService.getAllData().stream().map(res ->
                AddPack.builder()
                        .id(res.getId())
                        .imageBase64(getImageBase64(res.getImage()))
                        .pack_description(res.getPack_description())
                        .build()));
        return "/addPackage.html";
    }
    @PostMapping("/save")
    public String saveData(@Valid AddPackPojo addPackPojo) throws IOException {
        addPackService.saveData(addPackPojo);
        return "redirect:" +
                "/th-add/create";
    }
    @GetMapping("edit/{id}")
    public String getUpdateData(@PathVariable Integer id, Model model){
        AddPack addPack =addPackService.getByIdNotOpt(id);
        model.addAttribute("addPackPojo",new AddPackPojo(addPack));
        return "/addPackage.html";
    }
    @GetMapping("/delete/{id}")
    public String getDeleteData(@PathVariable Integer id){
        addPackService.deleteById(id);
        return "redirect:/th-add/create";
    }


    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/file_server/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }

}
