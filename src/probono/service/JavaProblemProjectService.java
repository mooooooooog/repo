package probono.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import probono.model.dao.ProblemDao;
import probono.model.dao.UserDao;
import probono.model.dto.Category;
import probono.model.dto.Problem;
import probono.model.dto.User;

public class JavaProblemProjectService {

    // singleton design pattern
    private static final JavaProblemProjectService instance = new JavaProblemProjectService();
    private final UserDao userDao = new UserDao();
    private final ProblemDao problemDao = new ProblemDao();
    private final Scanner scanner = new Scanner(System.in);

    private JavaProblemProjectService() {
    }

    public static JavaProblemProjectService getInstance() {
        return instance;
    }

    // 닉네임 중복 검사
    public boolean checkDuplicateNickname(String nickname) {
        ArrayList<User> users = userDao.getUsers();
        boolean b = false;
        if (!users.isEmpty()) {
            b = users.stream().anyMatch(user -> nickname.equals(user.getNickname()));
        }
        return b;
    }

    // 1. 모든 문제 풀기 (메인기능)
    public void getProblemList(User user) {
        ArrayList<Problem> problems = problemDao.getAllProblems();
        for (Problem problem : problems) {
            solve(user, problem);
        }
    }

    // 2. 원하는 문제 추가 풀기
    public void getProblem(User user, String category) {
        ArrayList<Problem> problems = problemDao.getAllProblems();
        Iterator<Problem> iterator = problems.iterator();

        Problem problem = null;

        for (Category c : Category.values()) {
            if (c.name().equals(category)) {
                Category findByCategory = Category.valueOf(category);
                while (iterator.hasNext()) {
                    problem = iterator.next();
                    if (problem.getCategory().equals(findByCategory)) {
                        break;
                    }
                }
            }
        }
        if (problem == null) {
            throw new IllegalStateException("카테고리를 정확하게 입력해주세요");
        }

        solve(user, problem);
    }

    private void solve(User user, Problem problem) {

        System.out.println(problem.getTitle());
        System.out.println(problem.getQuestion());

        String answer = scanner.nextLine();

        if (answer.equals(problem.getAnswer())) {
            user.setScore(user.getScore() + 10);
            System.out.println("정답을 맞히셨습니다!");
        } else {
            System.out.println("틀렸습니다!");
        }
    }
}
