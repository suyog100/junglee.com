package com.example.safari.junglesafari.Pojo;


import com.example.safari.junglesafari.entity.AddPack;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPackPojo {
    private Integer id;

    @NotEmpty(message = "Description can't be empty")
    private String pack_description;

    private MultipartFile image;

    public AddPackPojo(AddPack addPack){
        this.id = addPack.getId();
        this.pack_description = addPack.getPack_description();
    }
}
