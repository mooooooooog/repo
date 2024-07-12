package probono.view;

import probono.controller.JavaProblemProjectController;
import probono.model.dto.Category;
import probono.model.dto.JavaProblemRepository;
import probono.model.dto.User;

import java.util.Scanner;

public class StartView {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		JavaProblemRepository repository = JavaProblemRepository.getInstance();
		JavaProblemProjectController controller = JavaProblemProjectController.getInstance();

		System.out.println("*** 자바 문제 풀기 프로그램 ***");

		// 닉네임 입력받기
		String nickname = scanner.nextLine();

		if (controller.checkDuplicateNickname(nickname)) {
			nickname = scanner.nextLine();
		}

		User user = new User(nickname);
		repository.addUser(user);

		// 모든 문제 풀기
		System.out.println("\n*** 문제 풀이를 시작합니다 ***");
		controller.getProblemList(nickname);

		// 사용자 최종 점수 알려주기
		System.out.println(user.getNickname() +  "님의 최종 점수: "+ user.getScore());
		System.out.println(user.getNickname()+ " 님의 등급: " + user.getGrade());

		int menu = scanner.nextInt();

		while (menu!=3) {
			/* 추가 메뉴
			 *  1. 원하는 카테고리 문제 하나 풀기
			 *  2. 유저 정보 수정하기
			 *  3. 종료
			 *  4. 재시험
			 * */

			switch (menu) {
				case 1:
					// 원하는 카테고리 문제 하나 풀기
					System.out.println("\n*** 다시 풀고싶은 카테고리를 입력하세요: ***");
					// 카테고리 메뉴 출력
					System.out.println(Category.print());
					String category = scanner.nextLine();
					controller.getProblem(nickname, category);
					break;

				case 2:
					// 유저 정보 수정하기
					System.out.println("\n*** 수정할 닉네임을 입력하세요 ***");
					String newNickname = scanner.nextLine();
					if (!controller.checkDuplicateNickname(newNickname)) {
						newNickname = scanner.nextLine();
					}

					user = repository.getUserByNickname(nickname);
					user.setNickname(newNickname);
					break;

				case 3:
					break;

				case 4:
					System.out.println("*** 자바 문제 풀기 프로그램 ***");

					// 모든 문제 풀기
					System.out.println("\n*** 문제 풀이를 시작합니다 ***");
					controller.getProblemList(nickname);

					// 사용자 최종 점수 알려주기
					System.out.println(user.getNickname() +  "님의 최종 점수: "+ user.getScore());
					System.out.println(user.getNickname()+ " 님의 등급: " + user.getGrade());
					break;
			}
		}
	}

}
