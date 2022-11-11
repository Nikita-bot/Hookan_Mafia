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
import jakarta.ws.rs.QueryParam;
import ru.pazdrin.store.resources.controllers.ProductController;

/**
 *
 * @author nikit
 */
@Path("/product")
public class ProductRouter {
    @Inject
    ProductController pc;
    
    
    @GET
    @Produces("application/json")
    @Consumes("text/plain")
    public String getProducts(@QueryParam("id")Integer id,@QueryParam("type_id")Integer type_id,@QueryParam("brand_id")Integer brand_id){
        if(id == null){
            return pc.getAll(type_id,brand_id);
        }
        else return pc.getOne(id);
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String addProducts(@HeaderParam("token")String token, String req){
        return pc.addNew(token, req);
    }

}
