package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
;

@Entity
public class ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id ;
    private LocalDate dc;
    private LocalDate dd;
    private String description;

    private String etat;
    private String priority;

    @ManyToOne()
    private client client;

    @OneToOne
    private historique historique;

    @ManyToOne
    private tech tech;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDc() {
        return dc;
    }

    public void setDc(LocalDate dc) {
        this.dc = dc;
    }

    public LocalDate getDd() {
        return dd;
    }

    public void setDd(LocalDate dd) {
        this.dd = dd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


}
