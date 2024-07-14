package probono.model.dao;

import static probono.model.dto.Grade.*;

import java.util.ArrayList;
import probono.model.dto.User;

public class UserDao {
    static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User("대한", 10, BRONZE));
        users.add(new User("민국", 30, GOLD));
        users.add(new User("만세", 50, DIAMOND));
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByNickname(String nickname) {
        return users.stream().filter(user -> user.getNickname().equals(nickname)).findFirst().orElse(null);
    }

    public void resetNickname(String nickname, User newUser) {
        users.removeIf(user -> user.getNickname().equals(nickname));
        users.add(newUser);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
