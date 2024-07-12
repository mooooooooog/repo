package probono.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import probono.model.dto.Category;
import probono.model.dto.JavaProblemRepository;
import probono.model.dto.Problem;
import probono.model.dto.User;

public class JavaProblemProjectService {

	// singleton design pattern
	private static JavaProblemProjectService instance = new JavaProblemProjectService();

	private final JavaProblemRepository repository = JavaProblemRepository.getInstance();

	private final Scanner scanner = new Scanner(System.in);;

	private JavaProblemProjectService() {}

	public static JavaProblemProjectService getInstance() {
		return instance;
	}

	// 닉네임 중복 검사
	public boolean checkDuplicateNickname(String nickname) {
		ArrayList<User> users = repository.getUsers();
		boolean b = false;
		if (!users.isEmpty()) {
			b = users.stream().anyMatch(user -> nickname.equals(user.getNickname()));
		}
		return b;
	}

	// 1. 모든 문제 풀기 (메인기능)
	public void getProblemList(User user) {
		ArrayList<Problem> problems = repository.getProblems();
		for (Problem problem : problems) {
			solve(user, problem);
		}
	}

	// 2. 원하는 문제 추가 풀기
	public void getProblem(User user, String category) {
		ArrayList<Problem> problems = repository.getProblems();
		Iterator<Problem> iterator = problems.iterator();

		Problem problem = null;
		Category findByCategory = null;


		for (Category c : Category.values()) {
			if (c.name().equals(category)) {
				findByCategory = Category.valueOf(category);
			}
		}

		while (iterator.hasNext()) {
			Problem currentProblem = iterator.next();
			if (currentProblem.getCategory().equals(findByCategory)) {
				problem = currentProblem;
				break;
			}
		}

		if (problem != null) {
			solve(user, problem);
		} else {
			System.out.println("No problem found for category: " + category);
		}
	}

	private void solve(User user, Problem problem) {
		System.out.println(problem.getTitle());
		System.out.println(problem.getQuestion());

		String answer = scanner.nextLine();

		if (answer.equals(problem.getAnswer())) {
			user.setScore(user.getScore()+10);
			System.out.println("정답을 맞히셨습니다!");
		} else {
			System.out.println("틀렸습니다!");
		}
	}
}
