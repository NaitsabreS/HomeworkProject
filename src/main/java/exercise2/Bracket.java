package exercise2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Bracket {
    private String value;
    private int position;

    @Override
    public String toString() {
        return "Bracket{" +
                "value='" + value + '\'' +
                '}';
    }
}
