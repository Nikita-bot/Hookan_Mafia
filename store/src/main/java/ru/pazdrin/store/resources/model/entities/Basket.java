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
@Table(name = "basket", schema = "public")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "basket_id_gen")
    @SequenceGenerator(name = "basket_id_gen",sequenceName = "basket_id_seq",initialValue = 1,allocationSize = 1)
   
    int id;
    @Column(name = "user_id")
    int user_id;
    
    public int getId(){
        return this.id;
    }
    
    public int getUserId(){
        return this.user_id;
    }
    public void setUserId(int userId){
        this.user_id = userId;
    }
}
