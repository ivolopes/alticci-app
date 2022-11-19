package org.alticci.resources;

import org.alticci.exceptions.AlticciException;
import org.alticci.services.AlticciService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/alticci")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlticciResource {

    @Inject
    AlticciService service;

    @GET
    @Path("/{n}")
    public Response get(@PathParam("n") Integer number) throws AlticciException {
        List<Integer> sequeces = service.get(number);

        return Response.ok().entity(sequeces).build();
    }
}
