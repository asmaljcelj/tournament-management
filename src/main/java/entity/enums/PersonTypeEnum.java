package entity.enums;

public enum PersonTypeEnum {

    PLAYER("Player"),
    COACH("Coach"),
    UMPIRE("Umpire"),
    PRESIDENT("President"),
    PRESS("Press"),
    OTHER("Other"),
    VIP("Vip"),
    STAFF("Staff"),
    STAFF_OFFICIAL("Staff Official");

    private final String value;

    PersonTypeEnum(String value) {
        this.value = value;
    }

}
