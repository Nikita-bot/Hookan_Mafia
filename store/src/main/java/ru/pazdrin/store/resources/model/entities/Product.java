/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.pazdrin.store.resources.model.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 *
 * @author nikit
 */
@Entity
@Table(name = "product", schema = "public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_id_gen")
    @SequenceGenerator(name = "product_id_gen",sequenceName = "product_id_seq",initialValue = 1,allocationSize = 1)
    
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "price")
    int price;
    @Column(name = "img")
    String img;
    @Column(name = "type_id")
    int type_id;
    @Column(name = "brand_id")
    int brand_id;
    @Column(name = "strength")
    int strength;
    @Column(name = "description")
    String description;

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getImg() {
        return img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }
    
    public int getType_id() {
        return type_id;
    }
    
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    
    public int getBrand_id() {
        return brand_id;
    }
    
    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }
    
    public int getStrangth() {
        return strength;
    }
    
    public void setStrangth(int strength) {
        this.strength = strength;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
