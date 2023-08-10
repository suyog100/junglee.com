package com.example.safari.junglesafari.repository;

import com.example.safari.junglesafari.entity.AddPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddPackRepo extends JpaRepository<AddPack,Integer> {
}
