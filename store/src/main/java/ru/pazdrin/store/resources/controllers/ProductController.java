/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.pazdrin.store.resources.controllers;

import java.util.List;

import com.google.gson.Gson;

import jakarta.inject.Inject;
import ru.pazdrin.store.resources.model.Repositorys.ProductRepository;
import ru.pazdrin.store.resources.model.entitys.Product;
import ru.pazdrin.store.resources.model.entitys.User;
import ru.pazdrin.store.resources.model.middlewhere.ChekerToken;

/**
 *
 * @author nikit
 */
public class ProductController {
    Gson gson = new Gson();
    @Inject 
    Product prod;
    @Inject
    ProductRepository pr;

    public String getAll(Integer type_id,Integer brand_id){
        return gson.toJson(pr.getAll(type_id,brand_id));
    }
    
    public String addNew(String token,String req){
        User user = ChekerToken.check(token);
        if(user!=null && user.getRole() == 1){
            prod = gson.fromJson(req, Product.class);
            pr.create(prod);
            return "Ok";
        }
        else{
            return "У вас недостаточно прав";
        }
        
    }
    
    public String getOne(Integer id){
        return gson.toJson(pr.getOne(id));
    }
}
