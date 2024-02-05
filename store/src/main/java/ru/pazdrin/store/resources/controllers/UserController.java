/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.pazdrin.store.resources.controllers;


import java.util.List;

import com.auth0.jwt.exceptions.JWTCreationException;

import com.google.gson.Gson;

import jakarta.inject.Inject;
import ru.pazdrin.store.resources.model.Repositorys.UserRepository;
import ru.pazdrin.store.resources.model.entitys.User;
import ru.pazdrin.store.resources.model.middlewhere.ChekerToken;
import ru.pazdrin.store.resources.model.middlewhere.JWToken;

/**
 *
 * @author nikit
 */
public class UserController implements Runnable  {
    @Inject
    User user;
    @Inject
    UserRepository ur;
    
    public String registration(String req){
        String token = null;
        
        Gson gs = new Gson();
        user = gs.fromJson(req, User.class);

        user.setRole(0);

        Integer id = ur.getUserByPhone(user.getPhone());
        System.out.println(id);
        if(id == 0){
            user = ur.create(user);
            System.out.println(user.getId());
        }
        else{
            return "Такой уже существует";
        }

        try{
           token = JWToken.generateToken(user.getId(), user.getName(), user.getRole());
        }
        catch(JWTCreationException e){
            return "Error";
        }

        return token;
    }
    
    public String login(String phone, String pass){
        String token = "";
        int id = ur.getUserByPhone(phone);
        if (id != 0){
            user = ur.getUser(phone,pass);
            if(user == null){
                return "Неверный пароль";
            }
            token = JWToken.generateToken(user.getId(), user.getName(), user.getRole());
        }
        else{
            return "Пользователь не найден";
        }
        
        return token;
    }
    
    public String check(String token){
        
        Gson gson = new Gson();
        User user = ChekerToken.check(token);
        if(user!=null){
            return token;
        }
        else return "Invalid token";
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
