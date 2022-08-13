package com.example.demo.repo;

import com.example.demo.model.client;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.historique;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface historiquerepo extends JpaRepository<historique,  Long> {

    void deleteById(Long id);

    Optional<historique> findById(Long id);
}
