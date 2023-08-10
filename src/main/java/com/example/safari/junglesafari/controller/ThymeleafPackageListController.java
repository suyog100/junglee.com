package com.example.safari.junglesafari.controller;


import com.example.safari.junglesafari.Pojo.AddPackPojo;
import com.example.safari.junglesafari.Pojo.AdminPagePojo;
import com.example.safari.junglesafari.entity.AddPack;
import com.example.safari.junglesafari.repository.UserRepo;
import com.example.safari.junglesafari.service.AddPackService;
import com.example.safari.junglesafari.service.AdminPageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Controller
@RequestMapping
@RequiredArgsConstructor

public class ThymeleafPackageListController {
    private final AddPackService addPackService;
    private final UserRepo userRepo;
    private final AdminPageService adminPageService;

    @GetMapping("/create")
    public String getFormPage(Model model) {
        model.addAttribute("addPackPojo", new AddPackPojo());
        model.addAttribute("packs", addPackService.getAllData().stream().map(res ->
                AddPack.builder()
                        .id(res.getId())
                        .imageBase64(getImageBase64(res.getImage()))
                        .pack_description(res.getPack_description())
                        .build()));
        return "/packageList.html";
    }

    @GetMapping("/make")
    public String getPackPage(Model model){
        model.addAttribute("adminPagePojo", new AdminPagePojo());
        return "booking.html";
    }
    @PostMapping("/save")
    public String saveData(@Valid AdminPagePojo adminPagePojo) throws IOException {
        adminPageService.saveData(adminPagePojo);
        return "redirect:/create";
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
