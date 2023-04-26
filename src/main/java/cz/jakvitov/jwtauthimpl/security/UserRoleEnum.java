package cz.jakvitov.jwtauthimpl.security;

public enum UserRoleEnum {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    UserRoleEnum (String s){
        this.textValue = s;
    }

    private final String textValue;

    public String getTextValue() {
        return textValue;
    }
}
