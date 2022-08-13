package com.example.demo.repo;

import com.example.demo.model.client;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ticket;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface ticketrepo extends JpaRepository<ticket, Long> {
    void deleteById(Long id);

    Optional<ticket> findById(Long id);
}
