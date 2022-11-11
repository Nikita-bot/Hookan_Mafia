/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.pazdrin.store.resources.routers;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import ru.pazdrin.store.resources.controllers.UserController;


/**
 *
 * @author nikit
 */
@Path("/user")
public class UserRouter {
    
    @Inject
    UserController uc;
    
    @GET
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public String login(@QueryParam("phone")String phone,@QueryParam("pass")String password){
        return uc.login(phone,password);
    }
    
    @POST
    @Path("/reg")
    @Consumes("application/json")
    @Produces("application/json")
    public String reg(String req){ 
        return uc.registration(req);
    }
    
    @POST
    @Path("/auth")
    @Consumes("application/json")
    @Produces("application/json")
    public String auth(@HeaderParam("token")String token){
        System.out.println(token);
        return uc.check(token);
    }
}
