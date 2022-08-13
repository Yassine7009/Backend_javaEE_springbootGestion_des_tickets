package com.example.demo.service;

import com.example.demo.exception.Usernotfoundexception;
import com.example.demo.model.tech;
import com.example.demo.repo.techrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class techservice {
    private final techrepo techrepo;

    @Autowired
    public techservice(techrepo techrepo) {
        this.techrepo = techrepo;
    }

    public tech addtech(tech tech) {
        return techrepo.save(tech);
    }

    public List<tech> findAlltechs() {
        return techrepo.findAll();
    }

    public tech updatetech(tech tech) {
        return techrepo.save(tech);
    }

    public tech findtechById(Long id) {
        return techrepo.findById(id)
                .orElseThrow(() -> new Usernotfoundexception("User by id " + id + " was not found"));
    }

    public void deletetech(Long id){
        techrepo.deleteById(id);
    }


}
