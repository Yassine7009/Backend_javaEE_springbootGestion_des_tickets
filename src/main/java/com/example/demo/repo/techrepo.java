package com.example.demo.repo;

import com.example.demo.model.client;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.tech;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface techrepo extends JpaRepository<tech ,Long> {
    void deleteById(Long id);

    Optional<tech> findById(Long id);
}
