package com.example.safari.junglesafari;


import com.example.safari.junglesafari.entity.AddPack;
import com.example.safari.junglesafari.entity.AdminPage;
import com.example.safari.junglesafari.repository.AddPackRepo;
import com.example.safari.junglesafari.repository.AdminPageRepo;
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
public class AdminPageTesting {
    @Autowired
    private AddPackRepo addPackRepo;

    @Test

    @Order(1)

    @Rollback(value = false)

    public void saveResTest(){

        AddPack product = AddPack.builder()

                .pack_description("this is a nice package")

                .image("photo")

                .build();


        addPackRepo.save(product);



        Assertions.assertThat(product.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    public  void getResTest(){
        AddPack pcksent= addPackRepo.findById(1).get();
        Assertions.assertThat(pcksent.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfResTest(){
        List<AddPack> prod = addPackRepo.findAll();
        Assertions.assertThat(prod.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateResPriceTest(){

        AddPack prod = addPackRepo.findById(1).get();

        prod.setPack_description("dfadfad");

        AddPack productUpdated =  addPackRepo.save(prod);

        Assertions.assertThat(productUpdated.getPack_description()).isEqualTo("dfadfad");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteResTest(){
        AddPack prod = addPackRepo.findById(1).get();
        addPackRepo.delete(prod);

        AddPack prod1 = null;
        Optional<AddPack> isMsg = addPackRepo.findById(1);
        if(isMsg.isPresent()){
            prod1 = isMsg.get();
        }
        Assertions.assertThat(prod1).isNull();
    }

}
