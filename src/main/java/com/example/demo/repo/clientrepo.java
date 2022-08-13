package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.client;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface clientrepo extends JpaRepository<client, Long>{

    void deleteById(Long id);

    Optional<client> findById(Long id);
}
