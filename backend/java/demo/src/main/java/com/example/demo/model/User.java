package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "all_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "number_of_orders")
    private Integer numberOfOrders;

    @Column(name = "sum_orders")
    private Integer sumOrders;

    public User() {
    }

    public User(String username, String mail, String phoneNumber) {
        this.username = username;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.numberOfOrders = 0;
        this.sumOrders = 0;
    }


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getNumberOfOrders() {
        return numberOfOrders;
    }

    public Integer getSumOrders() {
        return sumOrders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNumberOfOrders(Integer numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public void setSumOrders(Integer sumOrders) {
        this.sumOrders = sumOrders;
    }
}
