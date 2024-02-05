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
@Table(name = "user",schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen",sequenceName = "user_id_seq",initialValue = 1,allocationSize = 1)
    int id;
    @Column(name = "phone")
    String phone;
    @Column(name = "password")
    String password;
    @Column(name = "role")
    int role;
    @Column(name = "name")
    String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
   
    public int getRole(){
        return role;
    }
    
    public void setRole(int role){
        this.role = role;
    }   
    
}
