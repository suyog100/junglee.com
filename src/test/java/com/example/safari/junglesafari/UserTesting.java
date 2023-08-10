package com.example.safari.junglesafari;

import com.example.safari.junglesafari.entity.User;
import com.example.safari.junglesafari.repository.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTesting {
    @Autowired
    private UserRepo userRepo;
    @Test

    @Order(1)

    @Rollback(value = false)

    public void saveEmployeeTest(){

        User customer = User.builder()

                .fullName("nibu")

                .password("paribesh")

                .email("nibu@gmail.com")

                .build();



        userRepo.save(customer);



        Assertions.assertThat(customer.getId()).isGreaterThan(0);

    }
    @Test
    @Order(2)
    public  void getUserTest(){
        User bookerCreated= userRepo.findById(1).get();
        Assertions.assertThat(bookerCreated.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfCustomerTest(){
        List<User> users = userRepo.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){

        User user = userRepo.findById(1).get();

        user.setFullName("abc");

        User bookerUpdated =  userRepo.save(user);

        Assertions.assertThat(bookerUpdated.getFullName()).isEqualTo("abc");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){
        User user = userRepo.findById(1).get();
        userRepo.delete(user);

        User booker = null;
        Optional<User> opUser = userRepo.findById(1);
        if(opUser.isPresent()){
            booker = opUser.get();
        }
        Assertions.assertThat(booker).isNull();
    }
}

