package probono.view;

import probono.controller.JavaProblemProjectController;
import probono.model.dto.Category;
import probono.model.dto.JavaProblemRepository;
import probono.model.dto.Problem;
import probono.model.dto.User;

import java.util.Scanner;
import static probono.model.dto.Category.*;
import static probono.model.dto.Grade.GOLD;

public class StartView {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		JavaProblemRepository repository = JavaProblemRepository.getInstance();
		JavaProblemProjectController controller = JavaProblemProjectController.getInstance();

		// Problem 리스트
		Problem p1 = new Problem("Static에 관한 문제입니다.", "Q. Static 멤버 변수는 JVM Memory의 어느 영역에 저장되는가?", "method", Category.Static);
		repository.addProblem(p1);
		Problem p2 = new Problem("Builder에 관한 문제입니다.", "Q. Final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 의미하는 Lombok의 어노테이션은?", "@RequiredArgsConstructor", Category.Builder);
		repository.addProblem(p2);
		Problem p3 = new Problem("DataType에 관한 문제입니다.", "Q. 다음 코드와 같이 Wrapper 클래스의 인스턴스에 저장된 값을 기본 타입의 데이터로 변환하는 것을 나타내는 용어는? >> int i = new Integer(1);", "unboxing", Category.DataType);
		repository.addProblem(p3);
		Problem p4 = new Problem("Inheritance에 관한 문제입니다.", "Q. OOP 클래스를 만든다고 할 때, 다음 코드에서 생략된 부분을 작성하시오. >> public class OOP", "extends Object", Category.Inheritance);
		repository.addProblem(p4);
		Problem p5 = new Problem("MVC 관한 문제입니다.", "Q. 브라우저로부터 받은 요청을 구분해서 핵심 로직을 지정 및 실행하는 요소는?", "controller", Category.MVC);
		repository.addProblem(p5);


		//User 리스트
		User  user1 = new User("cc",0, GOLD);
		repository.addUser(user1);
		User  user2 = new User("bb",10, GOLD);
		repository.addUser(user2);
		User  user3 = new User("aa",110, GOLD);
		repository.addUser(user3);

		System.out.println("*** 자바 문제 풀기 프로그램 ***");

		// 닉네임 입력받기
		System.out.print("닉네임을 입력해주세요: ");
		String nickname = scanner.nextLine();

		while (controller.checkDuplicateNickname(nickname)) {
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

		int menu = 0;

		while (menu!=3) {
			/* 추가 메뉴
			 *  1. 원하는 카테고리 문제 하나 풀기
			 *  2. 유저 정보 수정하기
			 *  3. 종료
			 *  4. 재시험
			 * */
			System.out.println(" *** menu *** " +
					"\n 1.원하는 카테고리 문제 하나 풀기 " +
					"\n 2. 유저 정보 수정하기" +
					"\n 3. 종료하기" +
					"\n 4. 처음부터 다시 문제 풀기 " +
					"\n >>" );
			menu = scanner.nextInt();
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
					while(true) {
						if (controller.checkDuplicateNickname(newNickname)) {
							//닉네임 중복시 처리
							System.out.println("\n*** 이미 존재하는 닉네임입니다. 다시 입력해주세요  ***");
							newNickname = scanner.nextLine();

						}else {
							//중복 아닐때 while문 탈출
							break;
						}
					}

					user.setNickname(newNickname);
					System.out.println("바꿈 user >>" + user);
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
