package cz.jakvitov.jwtauthimpl.security.model;

public class AuthenticationRequestDto {

    private String userName;

    private String password;

    public AuthenticationRequestDto() {
    }

    public AuthenticationRequestDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
