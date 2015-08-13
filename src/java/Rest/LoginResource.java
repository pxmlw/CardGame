/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Business.PlayerBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.jms.Session;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Player;

/**
 *
 * @author pxmlw126com
 */
@RequestScoped
@Path("/login")

public class LoginResource { 
    
    @EJB PlayerBean pl;
    @GET
    @Path("{username}/{password}")
public JsonObject check(@PathParam("username") String username,@PathParam("password") String password,@HeaderParam("Accept")String acceptHeader) 
    {
        Player p = null;
        try {
             p=pl.get(username); 
         if (p.getPassword().equals(password))
         return p.toJson();
         else
         return null;   
        } 
        catch (Exception e) {
         return null;
        }
        
         
    }
}