package ru.pazdrin.store.resources.transport.routers;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
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
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public String addAll(@HeaderParam("token")String token, @FormParam("product_id") int product_id,@FormParam("count")int count){
        return bc.addNew(token, product_id,count);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public Response delOne(@HeaderParam("token")String token,@FormParam("product_id") String product_id){
        System.out.println("In Router");
        String res = bc.remove(token, product_id);
        if(res.equals("Ok")){
            return Response.status(Status.OK).entity("OK").build();
        }
        else{
            return Response.status(Status.UNAUTHORIZED).entity("Invalid token").build();
        }
    }

    @PUT
    public Response payment(@HeaderParam("token")String token){
        String res = bc.payment(token);
        if(res.equals("Ok")){
            return Response.status(Status.OK).entity("OK").build();
        }
        else{
            return Response.status(Status.UNAUTHORIZED).entity("Invalid token").build();
        }
    }

}
