package ru.pazdrin.store.resources.controllers;

import java.util.List;

import com.google.gson.Gson;

import jakarta.inject.Inject;
import ru.pazdrin.store.resources.model.Repositorys.BasketRepository;
import ru.pazdrin.store.resources.model.Repositorys.UserRepository;
import ru.pazdrin.store.resources.model.entitys.User;
import ru.pazdrin.store.resources.model.middlewhere.ChekerToken;
import ru.pazdrin.store.resources.model.middlewhere.JWToken;

public class BasketController {
    @Inject
    UserRepository ur;
    @Inject
    User user;
    @Inject
    BasketRepository br;

    public String getAll(String token){
        Gson gson = new Gson();
        User user = ChekerToken.check(token);
        if(user!=null){
            return gson.toJson(br.getAll(user.getId()));
        }
        else return "Invalid token";
    }

    public String addNew(String token,int product_id,int count){
        Gson gson = new Gson();
        User user = ChekerToken.check(token);
        if(user!=null){

            br.addNew(user.getId(), product_id, count);
            return gson.toJson(br.getAll(user.getId()));
        }
        else return "Invalid token";
        
    }   

    public String remove(String token,String product_id){
        Gson gson = new Gson();
        User user = ChekerToken.check(token);
        if(user!=null){
            br.remove(user.getId(), Integer.parseInt(product_id));
            return gson.toJson(br.getAll(user.getId()));
        }
        else return "Invalid token";
    }
}
