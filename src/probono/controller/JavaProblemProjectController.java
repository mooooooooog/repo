package probono.controller;

import probono.model.dto.Category;
import probono.service.JavaProblemProjectService;

public class JavaProblemProjectController {

	// singleton design pattern
	private static JavaProblemProjectController instance = new JavaProblemProjectController();

	private static JavaProblemProjectService service = JavaProblemProjectService.getInstance();

	private JavaProblemProjectController() {}

	public static JavaProblemProjectController getInstance() {
		return instance;
	}

	// 닉네임 중복 검사
	public boolean checkDuplicateNickname(String nickname) {
		return service.checkDuplicateNickname(nickname);
	}

	// 1. 모든 문제 풀기 (메인기능)
	public void getProblemList(String nickname) {
		service.getProblemList(nickname);
	}

	// 2. 원하는 문제 추가 풀기
	public void getProblem(String nickname, String category) {
		service.getProblem(nickname, category);
	}

	// 3. 유저 닉네임 수정하기


}
