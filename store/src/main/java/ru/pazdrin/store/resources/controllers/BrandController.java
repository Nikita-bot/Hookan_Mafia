/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.pazdrin.store.resources.controllers;

import java.util.List;

import com.google.gson.Gson;

import jakarta.inject.Inject;
import ru.pazdrin.store.resources.model.Repositorys.BrandRepository;
import ru.pazdrin.store.resources.model.entitys.Brand;
import ru.pazdrin.store.resources.model.entitys.User;
import ru.pazdrin.store.resources.model.middlewhere.ChekerToken;

/**
 *
 * @author nikit
 */
public class BrandController {
    @Inject
    Brand brand;
    @Inject
    BrandRepository br;

    public String getAll(){
        
        Gson gson = new Gson();        
        return gson.toJson(br.getAll()); 
    }
    
    public String addNew(String token, String req){
        Gson gson = new Gson();
        User user = ChekerToken.check(token);
        if(user!=null && user.getRole() == 1){
            brand = gson.fromJson(req, Brand.class);
            br.create(brand);
            return "Ok";
        }
        else{
            return "У вас недостаточно прав";
        }
        
    }
    
}
