package probono.model.dto;

import probono.service.JavaProblemProjectService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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

    public Problem getProblem(String category){
        Iterator<Problem> iterator = problems.iterator();

        for (Category c : Category.values()){
            if (c.name().equals(category)){
                Category findByCategory = Category.valueOf(category);
                while (iterator.hasNext()) {
                    if (iterator.next().getCategory().equals(findByCategory)) {
                        return iterator.next();
                    }
                }
            }
        }


        return null;
    }

}
