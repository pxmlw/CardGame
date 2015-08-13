package Rest;

import Business.PlayerBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.ApplicationScoped;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Card;
import model.CombineClass;
import model.Game;
import model.GameRoom;
import model.Player;
import model.SetGame;
@ApplicationScoped
@Path("/GameList")
public class GameResource {

    @Inject 
    private GameRoom gm;
    @EJB
    PlayerBean playerbean;
    @Inject 
    private CombineClass cm;
    @Path("{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void createGame(@PathParam("username") String username, @HeaderParam("Accept") String acceptHeader) {
       
        
        Game game=new Game(username);
        gm.addgame(game);
        SetGame setgame=new SetGame();
        cm.add(game, setgame);
        setgame.setId(game.getGameID());
        ArrayList<Card> table=new ArrayList<Card>();
        setgame.setDeck(setgame.createShuffledDeck());
        table=setgame.moveCards(setgame.getDeck(), setgame.getTable(), 12);
        setgame.setTable(table);
        

    }

    @Path("/showGamelist")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray showGamelist() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        System.out.println("aaa2");
        try {
            ArrayList a = gm.getGameList();
            for (Object a1 : a) {
                Game g = (Game) a1;
                System.out.println(g.getGameID());
                builder.add(g.toJson());
            }
          
            return (builder.build());
        } catch (Exception e) {
            return null;
        }
    }

//    @Path("{gameid},{username}")
//    @GET
//    public void JoinGame(@PathParam("gameid") Integer gameId, @PathParam("username") String username, @HeaderParam("Accept") String acceptHeader) {
//        GameRoom gm = new GameRoom();
////        Game template = gm.Findgame(gameId);
//        template.getPlayerlist().add(username);
}

//}
//    @GET
//    @Path("{id}")   
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
//    public JsonObject get(@PathParam("id") Integer cardId
//            , @HeaderParam("Accept") String acceptHeader) {
//        Card c = cl.getcard(cardId);
//        return (c.toJson());
//    }

