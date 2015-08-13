package Rest;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import model.ParticipantList;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.SseFeature;

@RequestScoped
@Path("/gameroom/{gameid}")
public class GResource {
    
    @Inject private ParticipantList participants;
    
     @GET     
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public Response connect() {
        
         System.out.println(">>> new connection ");
         EventOutput eo = new EventOutput();
         participants.add(eo);
         return (Response.ok(eo).build());
    }
    
}
