package com.example.demo.service;

import com.example.demo.exception.Usernotfoundexception;
import com.example.demo.model.historique;
import com.example.demo.repo.historiquerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class historiqueservice {
    private final historiquerepo historiquerepo;

    @Autowired
    public historiqueservice(historiquerepo historiquerepo) {
        this.historiquerepo = historiquerepo;
    }

    public historique addhistorique(historique historique) {
        return historiquerepo.save(historique);
    }

    public List<historique> findAllhistoriques() {
        return historiquerepo.findAll();
    }

    public historique updatehistorique(historique historique) {
        return historiquerepo.save(historique);
    }

    public historique findhistoriqueById(Long id) {
        return historiquerepo.findById(id)
                .orElseThrow(() -> new Usernotfoundexception("User by id " + id + " was not found"));
    }

    public void deletehistorique(Long id){
        historiquerepo.deleteById(id);
    }


}

