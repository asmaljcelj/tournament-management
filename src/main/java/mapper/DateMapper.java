package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.time.LocalDate;
import java.time.LocalTime;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface DateMapper {

    default String toDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.toString();
    }

    default String toTime(LocalTime time) {
        if (time == null) {
            return null;
        }
        return time.toString();
    }

}
