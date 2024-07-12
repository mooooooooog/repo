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

    public Grade getGrade() {
        if (score >= 50) return Grade.DIAMOND;
        else if (score >= 40) return Grade.PLATINUM;
        else if (score >= 30) return Grade.GOLD;
        else if (score >= 20) return Grade.SILVER;
        else return Grade.BRONZE;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("USER_NO : ");
        builder.append(no);
        builder.append("\n USER_NICKNAME : ");
        builder.append(nickname);
        builder.append("\n USER_GRADE : ");
        builder.append(grade);
        return builder.toString();
    }
}
