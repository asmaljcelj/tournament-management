package model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import entity.enums.GenderEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonDto {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("country")
    private String country;
    @JsonProperty("gender")
    private GenderEnum gender;
    @JsonProperty("birthday")
    private String birthday;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("external_id")
    private String externalId;


}
