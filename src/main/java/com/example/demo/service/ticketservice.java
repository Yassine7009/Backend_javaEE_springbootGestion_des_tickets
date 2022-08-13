package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.Usernotfoundexception;
import com.example.demo.repo.ticketrepo;
import com.example.demo.model.ticket;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ticketservice {
    private final ticketrepo ticketrepo;

    @Autowired
    public ticketservice(ticketrepo ticketrepo) {this.ticketrepo = ticketrepo;}


    public ticket addticket(ticket ticket) {
        return ticketrepo.save(ticket);
    }

    public List<ticket> findAlltickets() {
        return ticketrepo.findAll();
    }

    public ticket updateticket(ticket ticket) {
        return ticketrepo.save(ticket);
    }

    public ticket findclientById(Long id) {
        return ticketrepo.findById(id)
                .orElseThrow(() -> new Usernotfoundexception("User by id " + id + " was not found"));
    }

    public void deleteticket(Long id){
        ticketrepo.deleteById(id);
    }


}
