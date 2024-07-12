package probono.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    static int no;

    private String nickname;

    private int score;

    private Grade grade;

    public User(String nickname) {
        this.nickname = nickname;
        no++;
        score = 0;
    }
}
