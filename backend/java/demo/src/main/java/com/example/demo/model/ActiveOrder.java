package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "active_orders")
public class ActiveOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idClient;

    private String clientName;

    private String nameAllsneakers;

    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getNameAllsneakers() {
        return nameAllsneakers;
    }

    public void setNameAllsneakers(String nameAllsneakers) {
        this.nameAllsneakers = nameAllsneakers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
