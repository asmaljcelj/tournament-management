package api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.dto.EventDto;
import model.dto.EventListResponseDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/event")
@Tag(name = "Event")
@Produces(MediaType.APPLICATION_JSON)
public interface EventApi {

    @GET
    @Operation(summary = "Get all events in DB")
    EventListResponseDto getEvents();

    @POST
    @Operation(summary = "Create a new event entry in DB")
    void createPerson(EventDto event);

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update event in DB")
    void updatePerson(@PathParam("id") Long id, EventDto event);

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete event in DB")
    void deletePerson(@PathParam("id") Long id);

}
