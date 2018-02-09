package am.aua.aoop;

import am.aua.aoop.model.User;

import java.util.ArrayList;

public class UserCatalog {
    private ArrayList<User> users;

    public UserCatalog() {
        this.users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void createUser(String username){
        users.add(new User(username));
    }

    public User getUser(String userID) {
        User user1 = null;
        for(User user : users)
        {
            if(user.getUSER_ID().equals(userID))
            {
                user1 = user;
            }
        }

        return user1;
    }
}
