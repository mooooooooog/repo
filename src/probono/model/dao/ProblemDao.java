package probono.model.dao;

import java.util.ArrayList;
import probono.model.dto.Category;
import probono.model.dto.Problem;

public class ProblemDao {
    static ArrayList<Problem> problems = new ArrayList<>();

    static {
        problems.add(new Problem("Static에 관한 문제입니다.", "Q. Static 멤버 변수는 JVM Memory의 어느 영역에 저장되는가?", "method", Category.Static));
        problems.add(new Problem("Builder에 관한 문제입니다.", "Q. Final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 의미하는 Lombok의 어노테이션은?", "@RequiredArgsConstructor", Category.Builder));
        problems.add(new Problem("DataType에 관한 문제입니다.", "Q. 다음 코드와 같이 Wrapper 클래스의 인스턴스에 저장된 값을 기본 타입의 데이터로 변환하는 것을 나타내는 용어는? >> int i = new Integer(1);", "unboxing", Category.DataType));
        problems.add(new Problem("Inheritance에 관한 문제입니다.", "Q. OOP 클래스를 만든다고 할 때, 다음 코드에서 생략된 부분을 작성하시오. >> public class OOP", "extends Object", Category.Inheritance));
        problems.add(new Problem("MVC 관한 문제입니다.", "Q. 브라우저로부터 받은 요청을 구분해서 핵심 로직을 지정 및 실행하는 요소는?", "controller", Category.MVC));
    }

    public ArrayList<Problem> getAllProblems() {
        return problems;
    }

    public void getProblem(Category category) {

    }

    public void insertProblem(int index, Problem problem) {
        problems.add(index, problem);
    }

    public void deleteProblem(int index) {
        problems.remove(index);
    }

}
