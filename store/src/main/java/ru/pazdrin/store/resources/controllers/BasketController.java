package ru.pazdrin.store.resources.controllers;

import java.util.List;

import com.google.gson.Gson;

import jakarta.inject.Inject;
import ru.pazdrin.store.resources.model.Payment;
import ru.pazdrin.store.resources.model.Repositorys.BasketRepository;
import ru.pazdrin.store.resources.model.Repositorys.UserRepository;
import ru.pazdrin.store.resources.model.entitys.User;
import ru.pazdrin.store.resources.model.middlewhere.ChekerToken;
import ru.pazdrin.store.resources.transport.websocket.PaymentSocket;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import java.util.concurrent.CompletableFuture;
import javax.naming.InitialContext;
import ru.pazdrin.store.resources.transport.websocket.PaymentSocket;

public class BasketController {
    @Inject
    UserRepository ur;
    @Inject
    User user;
    @Inject
    BasketRepository br;
    Gson gson = new Gson();

    public String getAll(String token){
        
        user = ChekerToken.check(token);
        if(user!=null){
            return gson.toJson(br.getAll(user.getId()));
        }
        else return "Invalid token";
    }

    public String addNew(String token,int product_id,int count){
        user = ChekerToken.check(token);
        if(user!=null){

            br.addNew(user.getId(), product_id, count);
            return gson.toJson(br.getAll(user.getId()));
        }
        else return "Invalid token";
        
    }   

    public String remove(String token,String product_id){
        user = ChekerToken.check(token);
        if(user!=null){
            br.remove(user.getId(), Integer.parseInt(product_id));
            return gson.toJson(br.getAll(user.getId()));
        }
        else return "Invalid token";
    }
    
    public String payment(String token){
        user = ChekerToken.check(token);
        if(user!=null){
            doPaymentAsync(user.getId());
            return "Ok";
        }
        else return "Invalid token";
    }
    
    public void doPaymentAsync(Integer userId){
        try{
            InitialContext context = new InitialContext();
            ManagedExecutorService mec = (ManagedExecutorService) context.lookup("concurrent/HookahMafia");
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> Payment.doPayment(), mec);
            
            future.thenAccept(res ->{
                PaymentSocket.notifyClient(userId);
            });
            
        }
        catch(Exception e){
        
        }
    }
}
