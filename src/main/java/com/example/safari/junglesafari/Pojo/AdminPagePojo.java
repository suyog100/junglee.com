package com.example.safari.junglesafari.Pojo;
import com.example.safari.junglesafari.entity.AdminPage;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminPagePojo {
    private Integer id;
    @NotEmpty(message = "name can't be empty")
    private String fullname;

    @NotEmpty(message = " email can't be empty")
    private String email;




    private Integer contact_number;
    @NotEmpty(message = " Package can't be empty")

    private String PackageNo;


    public AdminPagePojo(AdminPage adminPage){
        this.id=adminPage.getId();
        this.fullname = adminPage.getFullname();
        this.email = adminPage.getEmail();
        this.contact_number = adminPage.getContact_number();
        this.PackageNo = adminPage.getPackageNo();
    }


}

