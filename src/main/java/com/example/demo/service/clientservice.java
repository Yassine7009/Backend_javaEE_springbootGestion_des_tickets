package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.Usernotfoundexception;
import com.example.demo.repo.clientrepo;
import com.example.demo.model.client;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class clientservice {
    private final clientrepo clientrepo;

    @Autowired
    public clientservice(clientrepo clientrepo) {
        this.clientrepo = clientrepo;
    }

    public client addclient(client client) {
        return clientrepo.save(client);
    }

    public List<client> findAllclients() {
        return clientrepo.findAll();
    }

    public client updateclient(client client) {
        return clientrepo.save(client);
    }

    public client findclientById(Long id) {
        return clientrepo.findById(id)
                .orElseThrow(() -> new Usernotfoundexception("User by id " + id + " was not found"));
    }

    public void deleteclient(Long id){
        clientrepo.deleteById(id);
    }


}
