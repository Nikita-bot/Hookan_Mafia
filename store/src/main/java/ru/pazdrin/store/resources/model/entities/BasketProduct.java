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
@Table(name = "basket_product", schema = "public")
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "basket_product_id_gen")
    @SequenceGenerator(name = "basket_product_id_gen",sequenceName = "basket_product_id_seq",initialValue = 1,allocationSize = 1)   
    int id;
    @Column(name = "product_id")
    int product_id;
    @Column(name = "basket_id")
    int basket_id;
    @Column(name = "count")
    int count;
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId(){
        return this.id;
    }
    
    public int getProductId(){
        return this.product_id;
    }
    
    public void setProductId(int userId){
        this.product_id = userId;
    }
    
    public int getBascetId(){
        return this.basket_id;
    }
    
    public void setBascetId(int basket_id){
        this.basket_id = basket_id;
    }
}
