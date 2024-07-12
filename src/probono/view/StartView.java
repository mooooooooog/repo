/** 
4 * PROJECT  : 재능기부 프로젝트
 * NAME  :  StartView.java
 * DESC  : 실행 클래스
 * 		     기부자, 수혜자, 재능기부 종류 및 실제 진행되는 프로젝트 생성 및 CRUD 로직을 test하는 클래스
 * 
 * @author  
 * @version 1.0
*/

package probono.view;

import probono.controller.JavaProblemProjectController;
import probono.controller.TalentDonationProjectController;
import probono.model.dto.Category;
import probono.model.dto.JavaProblemProject;
import probono.model.dto.JavaProblemRepository;
import probono.model.dto.Problem;
import probono.model.dto.TalentDonationProject;
import probono.model.dto.User;

import java.util.Scanner;

public class StartView {

	public static void main(String[] args) {

//		// 기부자 정보 - 사번, 사원명, 이메일, 기부하기를 희망하는 재능기부 종류
//		Donator donator1 = new Donator(7369, "김의사", "kimdoc@company.com", "슈바이처 프로젝트");
//		Donator donator2 = new Donator(7156, "신예능", "shin@company.com", "오드리햅번 프로젝트");
//		Donator donator3 = new Donator(8012, "이레사", "lee@company.com", "마더테레사 프로젝트");
//		Donator donator4 = new Donator(7777, "박메너", "parkdoc@company.com", "슈바이처 프로젝트");
//
//		// 수혜자 정보 - 수혜자 번호, 이름, 연락처, 기부 받기를 희망하는 재능기부 종류
//		Beneficiary beneficiary1 = new Beneficiary(100, "김연약", "010-111-1111", "슈바이처 프로젝트");
//		Beneficiary beneficiary2 = new Beneficiary(101, "박아트", "010-222-2222", "오드리햅번 프로젝트");
//		Beneficiary beneficiary3 = new Beneficiary(105, "이건강", "010-555-5555", "마더테레사 프로젝트");
//		Beneficiary beneficiary4 = new Beneficiary(103, "맘아픔", "010-333-3333", "슈바이처 프로젝트");
//
//		// 재능기부 종류 - 구분, 활동영역, 활동예시
//		TalentDonationType schweitzer = new TalentDonationType("슈바이처 프로젝트", "의료, 보건, 건강과 관련된 분야",
//				"의사, 한의사, 수의사, 스포츠 마사지, 수지침, 이혈, 발마사지 등 의료 활동이나 의료 활동을 위한 후원, 보건, 의료 활동 보조, 대체의학 요번, 보건위생, 응급 처치등");
//		TalentDonationType audreyHepbun = new TalentDonationType("오드리햅번 프로젝트", "문화, 예술 관련 분야",
//				"예술가, 문화관련 프로그램 제공, 전시ㆍ관람 등 기회제공, 사진, 영상, 디자인, 메이크업, 마술, 모델, 활용 캠페인 등");
//		TalentDonationType motherTeresa = new TalentDonationType("마더테레사 프로젝트", "저소득층 및 사회복지 분야",
//				"사회복지 관련 시설기관 봉사 및 후원, 독거노인 돌봄, 그룸혹, 쉼터 지원등");
//		TalentDonationType daddyLongLegs = new TalentDonationType("키다리아저씨 프로젝트", "멘토링, 상담, 교육, 결연 분야",
//				"결연, 상담, 멘토, 독서ㆍ학습지도 및 교육기회 제공, 장학지원, 심리상담 등 멘토링, 상담, 교육, 결연분야");
//		TalentDonationType heracles = new TalentDonationType("헤라클레스 프로젝트", "체육, 기능,기술 관련 분야",
//				"체육활동 및 교육, 집수리 봉사, 운전,"
//				+ " 배송, 엔지니어링, 기술 제공 및 자문등");
//
//		// 기부자, 수혜자가 매핑된 실제 진행되는 "재능 기부 프로젝트"
//		// 프로젝트명, 기부자, 수혜자, 재능기부종류, 시작일, 종료일, 재능기부 실제 내용
//		TalentDonationProject schweitzerProject
//		= new TalentDonationProject("01슈바이처", donator1, beneficiary1, schweitzer, "2024-11-31", "2024-12-03", 	"아토피 무상 치료");
//
//		TalentDonationProject audreyHepbunPorject = new TalentDonationProject("02오드리햅번", donator2, beneficiary2,
//				audreyHepbun, "2024-11-31", "2024-12-03", "예술가와의 만남");
//		TalentDonationProject motherTeresaProject = new TalentDonationProject("03마더테레사", donator3, beneficiary3,
//				motherTeresa, "2024-11-31", "2024-12-03", "독거 노인 식사 제공");
//
//
//		// 데이터 구성 후 서비스 로직 실행
//		TalentDonationProjectController controller = TalentDonationProjectController.getInstance();

		Scanner scanner = new Scanner(System.in);
		JavaProblemRepository repository = JavaProblemRepository.getInstance();
		JavaProblemProjectController controller = JavaProblemProjectController.getInstance();

		// Problem 리스트
		Problem p1 = new Problem("Static에 관한 문제입니다.", "Q. Static 멤버 변수는 JVM Memory의 어느 영역에 저장되는가?", "method", Static);
		repository.addProblem(p1);
		Problem p2 = new Problem("Builder에 관한 문제입니다.", "Q. Final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 의미하는 Lombok의 어노테이션은?", "@RequiredArgsConstructor", Builder);
		repository.addProblem(p2);
		Problem p3 = new Problem("DataType에 관한 문제입니다.", "Q. 다음 코드와 같이 Wrapper 클래스의 인스턴스에 저장된 값을 기본 타입의 데이터로 변환하는 것을 나타내는 용어는? >> int i = new Integer(1);", "unboxing", DataType);
		repository.addProblem(p3);
		Problem p4 = new Problem("Inheritance에 관한 문제입니다.", "Q. OOP 클래스를 만든다고 할 때, 다음 코드에서 생략된 부분을 작성하시오. >> public class OOP", "extends Object", Inheritance);
		repository.addProblem(p4);
		Problem p5 = new Problem("MVC 관한 문제입니다.", "Q. 브라우저로부터 받은 요청을 구분해서 핵심 로직을 지정 및 실행하는 요소는?", "controller", MVC);
		repository.addProblem(p5);

		System.out.println("*** 자바 문제 풀기 프로그램 ***");

		// 닉네임 입력받기
		System.out.print("닉네임을 입력해주세요: ");
		String nickname = scanner.nextLine();


		if (!controller.checkDuplicateNickname(nickname)) {
			nickname = scanner.nextLine();
		}

		User user = new User(nickname);
		repository.addUser(user);

		// 모든 문제 풀기
		System.out.println("\n*** 문제 풀이를 시작합니다 ***");
		controller.getProblemList();

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
					controller.getProblem(category);
					break;

				case 2:
					// 유저 정보 수정하기
					System.out.println("\n*** 수정할 닉네임을 입력하세요 ***");
					String newNickname = scanner.nextLine();
					if (!controller.checkDuplicateNickname(newNickname)) {
						newNickname = scanner.nextLine();
					}

					user = javaProblemRepository.getUserByNickname(nickname);
					user.setNickname(newNickname);
					break;

				case 3:
					break;

				case 4:
					System.out.println("*** 자바 문제 풀기 프로그램 ***");

					// 모든 문제 풀기
					System.out.println("\n*** 문제 풀이를 시작합니다 ***");
					controller.getProblemList();

					// 사용자 최종 점수 알려주기
					System.out.println(user.getNickname() +  "님의 최종 점수: "+ user.getScore());
					System.out.println(user.getNickname()+ " 님의 등급: " + user.getGrade());
					break;
			}
		}
	}

}
