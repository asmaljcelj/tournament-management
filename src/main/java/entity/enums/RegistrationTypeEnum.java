package entity.enums;

public enum RegistrationTypeEnum {

    ENTRY(0),
    ACCOMMODATION(1),
    OTHER(2);

    private int value;

    RegistrationTypeEnum(int value) {
        this.value = value;
    }

}
