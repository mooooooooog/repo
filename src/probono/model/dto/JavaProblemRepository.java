package probono.model.dto;

import java.util.ArrayList;

public class JavaProblemRepository {
    private static JavaProblemRepository instance = new JavaProblemRepository();

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Problem> problems = new ArrayList<>();

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

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

    public ArrayList<Problem> getProblems() {
        return problems;
    }
}
