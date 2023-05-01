package cz.jakvitov.jwtauthimpl.security;

public enum UserRoleEnum {

    USER("USER"),
    ADMIN("ADMIN");

    UserRoleEnum (String s){
        this.textValue = s;
    }

    private final String textValue;

    public String getTextValue() {
        return textValue;
    }
}
