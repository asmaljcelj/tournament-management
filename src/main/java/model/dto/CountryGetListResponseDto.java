package model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryGetListResponseDto
{

    private List<CountryDto> countries;

}
