package probono.view;

import probono.controller.JavaProblemProjectController;
import probono.model.dao.UserDao;
import probono.model.dto.Category;
import probono.model.dto.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StartView {

    public static void main(String[] args) {
        JavaProblemProjectController controller = JavaProblemProjectController.getInstance();

        System.out.println("*** 자바 문제 풀기 프로그램 ***");

        Scanner scanner = new Scanner(System.in);
        // 닉네임 입력받기
        System.out.print("닉네임을 입력해주세요: ");
        String nickname = scanner.nextLine();

        while (controller.checkDuplicateNickname(nickname)) {
            nickname = scanner.nextLine();
        }

        UserDao userDao = new UserDao();
        User user = new User(nickname);
        userDao.addUser(user);

        // 모든 문제 풀기
        System.out.println("\n*** 문제 풀이를 시작합니다 ***");
        controller.getProblemList(nickname);

        // 사용자 최종 점수 알려주기
        System.out.println(user.getNickname() + "님의 최종 점수: " + user.getScore());
        System.out.println(user.getNickname() + "님의 최종 등급: " + user.getGrade());

        int menu;
        do {
            user = userDao.getUserByNickname(nickname);

            // 메뉴 출력
            System.out.println("*** 메뉴 선택 ***");
            System.out.println("1. 원하는 카테고리 문제 하나 풀기");
            System.out.println("2. 유저 정보 수정하기");
            System.out.println("3. 종료하기");
            System.out.println("4. 처음부터 다시 문제 풀기");
            System.out.print("메뉴를 선택하세요 (1-4): ");

            // 숫자 입력 처리
            while (!scanner.hasNextInt()) {
                System.out.println("숫자를 입력해주세요.");
                System.out.println(">>");
                scanner.next(); // 잘못된 입력을 버림
            }

            menu = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            // 메뉴 선택에 따른 처리
            switch (menu) {
                case 1:
                    System.out.println("1번 메뉴를 선택하셨습니다.");
                    // 원하는 카테고리 문제 하나 풀기
                    System.out.println("\n*** 다시 풀고싶은 카테고리를 입력하세요: ***");
                    // 카테고리 메뉴 출력
                    System.out.println(Category.print());
                    String category = scanner.nextLine();
                    try {
                        if (category == null || category.trim().isEmpty()) {
                            throw new IllegalStateException("빈칸은 입력이 불가합니다.");
                        }
                        // 정규식 정의
                        String regex = "^[a-zA-Z]+$";
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(category);

                        if (!matcher.matches()) {
                            throw new IllegalStateException("카테고리를 다시 입력해주세요.");
                        } else {
                            controller.getProblem(nickname, category);
                            break;
                        }
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                case 2:
                    System.out.println("2번 메뉴를 선택하셨습니다.");
                    // 유저 정보 수정하기
                    System.out.println("\n*** 수정할 닉네임을 입력하세요 ***");
                    String newNickname = scanner.nextLine();

                    while (true) {
                        if (controller.checkDuplicateNickname(newNickname)) {
                            //닉네임 중복시 처리
                            System.out.println("\n*** 이미 존재하는 닉네임입니다. 다시 입력해주세요  ***");
                            newNickname = scanner.nextLine();

                        } else {
                            //중복 아닐때 while문 탈출
                            break;
                        }
                    }

                    // 현재 유저의 닉네임을 가진 객체를 list에서 지우고 user.set 한 후 수정한 user를 list에 add 해야할듯?
                    nickname = newNickname;
                    user.setNickname(newNickname);
                    controller.resetNickname(user.getNickname(), user);

                    System.out.println("\n바꿈 user >>" + user);
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                case 4:
                    System.out.println("4번 메뉴를 선택하셨습니다.");
                    System.out.println("*** 자바 문제 풀기 프로그램 ***");

                    // 모든 문제 풀기
                    System.out.println("\n*** 문제 풀이를 시작합니다 ***");
                    controller.getProblemList(nickname);

                    // 사용자 최종 점수 알려주기
                    System.out.println(user.getNickname() + "님의 최종 점수: " + user.getScore());
                    System.out.println(user.getNickname() + " 님의 등급: " + user.getGrade());
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택해주세요.");
                    break;
            }
            System.out.println();

        } while (menu != 3);
    }

}
