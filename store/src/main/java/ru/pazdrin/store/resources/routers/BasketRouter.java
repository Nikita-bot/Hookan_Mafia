package ru.pazdrin.store.resources.routers;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import ru.pazdrin.store.resources.controllers.BasketController;

@Path("/basket")
public class BasketRouter {
    @Inject
    BasketController bc;
    
    @GET
    @Produces("application/json")
    public String getAll(@QueryParam("token")String token){

        return bc.getAll(token);
    }

    @POST
    @Path("/creation")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public String addAll(@HeaderParam("token")String token, @FormParam("product_id") int product_id,@FormParam("count")int count){
        return bc.addNew(token, product_id,count);
    }

    @POST
    @Path("/destroy")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public String delOne(@HeaderParam("token")String token,@FormParam("product_id") String product_id){
        System.out.println("In Router");
        return bc.remove(token, product_id);
    }

}
