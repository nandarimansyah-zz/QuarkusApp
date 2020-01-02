package id.nanda;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kafka")
public class ProducerController {

    @Inject
    KafkaProducer producer;

    @POST
    @Path("/produce")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response produceMessage(String body) {
        producer.produce(body);
        return Response.status(201).build();
    }
}
