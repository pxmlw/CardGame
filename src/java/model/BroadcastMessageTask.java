/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;

/**
 *
 * @author cmlee
 */
public class BroadcastMessageTask implements Runnable {

    private ArrayList idlist=new ArrayList();
    private String gameid;
    private String username;
    private ParticipantList participants;

    public BroadcastMessageTask(String gameid,String username,ArrayList idlist, ParticipantList participants) {
        this.idlist=idlist;
        this.gameid = gameid;
        this.username = username;
        this.participants = participants;

    }

    @Override
    public void run() {
        System.out.println("come in");
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (int i=0;i<12;i++){
            String n=idlist.get(i).toString();
            JsonObject json = Json.createObjectBuilder()
                .add("gameid", gameid)
                .add("username", username)
                .add("id", n)
                .build();
            builder.add(json);
         
        }
        JsonArray list= builder.build();

        OutboundEvent data = new OutboundEvent.Builder()
                .data(JsonArray.class, list)
                .name(gameid)
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .build();
        participants.send(data);

    }

}
