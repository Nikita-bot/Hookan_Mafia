/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.pazdrin.store.resources.controllers;


import ru.pazdrin.store.resources.model.Repositorys.TypeRepository;
import ru.pazdrin.store.resources.model.entitys.Type;
import ru.pazdrin.store.resources.model.entitys.User;
import ru.pazdrin.store.resources.model.middlewhere.ChekerToken;
import ru.pazdrin.store.resources.model.middlewhere.JWToken;

import java.util.List;

import com.google.gson.Gson;

import jakarta.inject.Inject;

/**
 *
 * @author nikit
 */
public class TypeController {
    @Inject
    Type type;
    @Inject
    TypeRepository tr;
    @Inject 
    User user;

    public String getAll(){
        Gson gson = new Gson();
        return gson.toJson(tr.getAll()); 
    }
    
    public String addNew(String token, String req){
        Gson gson = new Gson();
        User user = ChekerToken.check(token);
        System.out.println("Add type:Controller User:" + token);
        if(user!=null ){
            
            type = gson.fromJson(req, Type.class);
            tr.create(type);
            return "Ok";
        }
        else{
            return "У вас недостаточно прав";
        }
        
    }
}
