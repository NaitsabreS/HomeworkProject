package exercise2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
//@ToString(exclude = "position") - does the same as method below
//@ToString(of = "value") - alternative
public class Bracket {
    private /*final*/ String value;
    private /*final*/ int position;

    @Override
    public String toString() {
        return "Bracket{" +
                "value='" + value + '\'' +
                '}';
    }
}
