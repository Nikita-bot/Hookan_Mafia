/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.pazdrin.store.resources.routers;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ru.pazdrin.store.resources.controllers.BrandController;

/**
 *
 * @author nikit
 */
@Path("/brand")
public class BrandRouter {
    
    @Inject
    BrandController bc;
    
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public String getBrands(){
        return bc.getAll();

    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String addBrand(@HeaderParam("token")String token,String req){
        return bc.addNew(token, req);
        
    }
}
