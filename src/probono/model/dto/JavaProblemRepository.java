package probono.model.dto;

import probono.service.JavaProblemProjectService;

import java.util.ArrayList;
import java.util.HashMap;

public class JavaProblemRepository {
    private static JavaProblemRepository instance = new JavaProblemRepository();

    static ArrayList<User> users;
    static ArrayList<Problem> problems;

    public static JavaProblemRepository getInstance() {
        return instance;
    }


    public User getUserByNickname(String nickname) {
        return users.stream().filter(user -> user.getNickname().equals(nickname)).findFirst().orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
