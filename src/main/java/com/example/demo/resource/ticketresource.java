package com.example.demo.resource;

import com.example.demo.model.ticket;
import com.example.demo.service.ticketservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class ticketresource {
    private final ticketservice ticketservice;

    public ticketresource(ticketservice ticketservice) {
        this.ticketservice = ticketservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ticket>> getAlltickets () {
        List<ticket> tickets = ticketservice.findAlltickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ticket> getticketById(@PathVariable("id") Long id) {
        ticket ticket = ticketservice.findclientById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ticket> addticket(@RequestBody ticket ticket) {
        ticket newticket = ticketservice.addticket(ticket);
        return new ResponseEntity<>(newticket, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ticket> updateticket(@RequestBody ticket ticket) {
        ticket updateticket = ticketservice.updateticket(ticket);
        return new ResponseEntity<>(updateticket, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteticket(@PathVariable("id") Long id) {
        ticketservice.deleteticket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
