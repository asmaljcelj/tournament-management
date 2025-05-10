package api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.dto.CountryDto;
import model.dto.CountryGetListResponseDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/country")
@Tag(name = "Country")
@Produces(MediaType.APPLICATION_JSON)
public interface CountryApi {

    @GET
    @Operation(summary = "Get all countries")
    CountryGetListResponseDto getCountries();

    @GET
    @Path("/{id}")
    @Operation(summary = "Get all countries in DB")
    CountryDto getCountryFetched(@PathParam("id") Long id);

    @POST
    @Operation(summary = "Create a new country entry in DB")
    void createCountry(CountryDto country);

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update country in DB")
    void updateCountry(@PathParam("id") Long id, CountryDto country);

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete country in DB")
    void deleteCountry(@PathParam("id") Long id);

}
