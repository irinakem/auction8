package am.aua.aoop.server;

import java.util.UUID;

public class User {

    private final String USER_ID;

    private String userName;

    public User(String userName) {
        this.userName = userName;
        USER_ID = UUID.randomUUID().toString();;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
