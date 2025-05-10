package api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.dto.HotelDto;
import model.dto.HotelListResponseDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/hotel")
@Tag(name = "Hotel")
@Produces(MediaType.APPLICATION_JSON)
public interface HotelApi {

    @GET
    @Operation(summary = "Get all hotel in DB")
    HotelListResponseDto getHotels();

    @GET
    @Path("/{id}")
    @Operation(summary = "Get all hotel in DB")
    HotelDto getHotelFetched(@PathParam("id") Long id);

    @POST
    @Operation(summary = "Create a new hotel entry in DB")
    void createHotel(HotelDto hotel);

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update hotel in DB")
    void updateHotel(@PathParam("id") Long id, HotelDto hotel);

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete hotel in DB")
    void deleteHotel(@PathParam("id") Long id);

}
