/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.sun.glass.ui.View;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.BroadcastMessageTask;
import model.Card;
import model.CombineClass;
import model.Game;
import model.GameRoom;
import model.ParticipantList;
import model.SetGame;
import org.glassfish.jersey.media.sse.EventOutput;
import org.json.JSONObject;

/**
 *
 * @author pxmlw126com
 */
@RequestScoped
@Path("/setgame")
public class TableResource {
    @Inject 
    private CombineClass cm;
    @Inject 
    private GameRoom gm;
    @Path("/startgame/{parameters}")
    @GET
    public JsonObject Startgame(@PathParam("parameters") int gameid) {
        Game g;
         g= gm.getgame(gameid);
        SetGame setgame=cm.get(g);
        ArrayList<Card> table=setgame.getTable();
        JsonObjectBuilder builder = Json.createObjectBuilder();

        builder.add("card1", table.get(0).getId());
        builder.add("card2", table.get(1).getId());
        builder.add("card3", table.get(2).getId());
        builder.add("card4", table.get(3).getId());
        builder.add("card5", table.get(4).getId());
        builder.add("card6", table.get(5).getId());
        builder.add("card7", table.get(6).getId());
        builder.add("card8", table.get(7).getId());
        builder.add("card9", table.get(8).getId());
        builder.add("card10", table.get(9).getId());
        builder.add("card11", table.get(10).getId());
        builder.add("card12", table.get(11).getId());
        return builder.build();
    }

    @Inject
    private ParticipantList participants;

    @Resource(lookup = "concurrent/gamepool")
    private ManagedScheduledExecutorService service;

    @Path("{gameid}/{cd1}/{cd2}/{cd3}/{username}")
    @GET
    public Response findset(@PathParam("gameid") int id, @PathParam("cd1") int cd1, @PathParam("cd2") int cd2,
            @PathParam("cd3") int cd3, @PathParam("username") String username) {
        int i = 0;
        Card a, b, c;
        System.out.println("fuckkkkkkkkkkk");
        SetGame game=cm.get(gm.getgame(id));
        System.out.println(id);
        int x = id;
         String mx = String.valueOf(x);
        

            a = game.getCardMap().get(cd1);
            System.out.println("==> a.id" + a.getId());
            b = game.getCardMap().get(cd2);
            System.out.println("==> b.id" + b.getId());
            c = game.getCardMap().get(cd3);
            System.out.println("==> c.id" + c.getId());
            if (isSet(a, b, c)) {
                i = 1;
                game.getTable().remove(a);
                game.getTable().remove(b);
                game.getTable().remove(c);
                game.moveCards(game.getDeck(), game.getTable(), 3);
//                int k, j, h;
//                k = game.getTable().get(9).getId();
//                j = game.getTable().get(10).getId();
//                h = game.getTable().get(11).getId();
             ArrayList al=new ArrayList();
             for (int j=0;j<12;j++)
             {
                 int k =game.getTable().get(j).getId();
                 System.out.println(k);
                 al.add(k);
             }
                service.submit(new BroadcastMessageTask(mx, username,al, participants));
            }
            return Response.ok().build();
    
//        } catch (Exception e) {
//            System.out.println("fail");
//            return ;

        

}

    boolean isSet(Card a, Card b, Card c) {
        
        if (!((a.getNumber() == b.getNumber()) && (b.getNumber() == c.getNumber())
                || (a.getNumber() != b.getNumber()) && (a.getNumber() != c.getNumber()) && (b.getNumber() != c.getNumber()))) {
            return false;
        }
        if (!((a.getColor() == b.getColor()) && (b.getColor() == c.getColor())
                || (a.getColor() != b.getColor()) && (a.getColor() != c.getColor()) && (b.getColor() != c.getColor()))) {
            return false;
        }
        if (!((a.getSymbor() == b.getSymbor()) && (b.getSymbor() == c.getSymbor())
                || (a.getSymbor() != b.getSymbor()) && (a.getSymbor() != c.getSymbor()) && (b.getSymbor() != c.getSymbor()))) {
            return false;
        }
        if (!((a.getShading() == b.getShading()) && (b.getShading() == c.getShading())
                || (a.getShading() != b.getShading()) && (a.getShading() != c.getShading()) && (b.getShading() != c.getShading()))) {
            return false;
        }
        return true;
    }

}
