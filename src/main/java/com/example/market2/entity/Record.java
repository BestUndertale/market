package com.example.market2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "record")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String name;
    String price;
    String seller;
    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeller(){
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
