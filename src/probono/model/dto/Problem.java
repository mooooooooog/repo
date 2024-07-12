package probono.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Problem {
    private int no;

    private String title;

    private String question;

    private String answer;

    private Category category;

    public Problem(String title, String question, String answer, Category category) {
        ++no;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.category = category;
    }
}
