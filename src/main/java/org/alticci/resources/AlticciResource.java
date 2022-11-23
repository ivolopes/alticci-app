package org.alticci.resources;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.alticci.exceptions.AlticciException;
import org.alticci.services.AlticciService;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/alticci")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlticciResource {

    @Inject
    AlticciService service;

    @APIResponses({
        @APIResponse(responseCode = "200", description = "Alticci sequence calculated successfully"),
        @APIResponse(responseCode = "400", description = "If an invalide number was sent to " +
            "calculate the alticci sequence"),
        @APIResponse(responseCode = "500", description = "Internal error")
    })
    @GET
    @Path("/{n}")
    public Response get(@PathParam("n") Integer number) throws AlticciException {
        List<Integer> sequeces = service.get(number);

        return Response.ok().entity(sequeces).build();
    }
}
