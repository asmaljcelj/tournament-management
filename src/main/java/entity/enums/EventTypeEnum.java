package entity.enums;

public enum EventTypeEnum {

    YOUTH_CONTENDER("YOUTH_CONTENDER"),
    FEEDER("FEEDER"),
    CONTENDER("CONTENDER"),
    STAR_CONTENDER("STAR_CONTENDER"),
    EUROPEAN_CHAMPIONSHIP("EUROPEAN_CHAMPIONSHIP"),
    WORLD_CHAMPIONSHIP("WORLD_CHAMPIONSHIP");

    public final String value;

    EventTypeEnum(String value) {
        this.value = value;
    }

}
