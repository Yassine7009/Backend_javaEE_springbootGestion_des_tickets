package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id ;
    private String name;
    private int contact;

    public List<ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<ticket> tickets) {
        this.tickets = tickets;
    }

    @OneToMany(mappedBy= "client")
    private List<ticket> tickets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

}

