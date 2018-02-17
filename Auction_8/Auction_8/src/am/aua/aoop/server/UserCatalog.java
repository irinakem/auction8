package am.aua.aoop.server;

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
        User user1 = users.get(0);
        for(User user : users)
        {
            if(user.getUSER_ID().equals(userID))
            {
                user1 = user;
            }
        }

        return user1;
    }

    public void populateWithDummyData(){
        for (int i = 0; i < 20; i ++){
            createUser("User " + i);
        }
    }
}
