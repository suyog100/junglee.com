package com.example.safari.junglesafari.Pojo;


import com.example.safari.junglesafari.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private Integer id;

    @NotEmpty(message = "Email can't be empty")
    private String email;

    @NotEmpty(message = "Full name can't be empty")
    private String fullName;

//    @NotEmpty(message = "Mobile Number can't be empty")
//    private String mobile_no;

    @NotEmpty(message = "Password can't be empty")
    private String password;

    private MultipartFile image;

    public UserPojo(User user){
        this.id=user.getId();
        this.fullName=user.getFullName();
        this.email=user.getEmail();
//        this.mobile_no=user.getMobileNo();
        this.password=user.getPassword();
    }


}



