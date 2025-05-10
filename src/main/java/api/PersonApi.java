package api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.dto.PersonDto;
import model.dto.PersonGetListResponseDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/person")
@Tag(name = "Person")
@Produces(MediaType.APPLICATION_JSON)
public interface PersonApi {

    @GET
    @Operation(summary = "Get all people in DB")
    PersonGetListResponseDto getPeople();

    @GET
    @Path("/{id}")
    @Operation(summary = "Get all people in DB")
    PersonDto getPersonFetched(@PathParam("id") Long id);

    @POST
    @Operation(summary = "Create a new person entry in DB")
    void createPerson(PersonDto person);

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update person in DB")
    void updatePerson(@PathParam("id") Long id, PersonDto person);

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete person in DB")
    void deletePerson(@PathParam("id") Long id);

}
