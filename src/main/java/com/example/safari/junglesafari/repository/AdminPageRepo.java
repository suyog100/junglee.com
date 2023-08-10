package com.example.safari.junglesafari.repository;
import com.example.safari.junglesafari.entity.AdminPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminPageRepo extends JpaRepository<AdminPage,Integer> {
}