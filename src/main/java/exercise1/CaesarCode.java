package exercise1;

public class CaesarCode {
    StringBuilder stringBuilder = new StringBuilder();

    public String encryptOrDecrypt(String input) {
        char[] inputArray = input.toCharArray();
        for (char c : inputArray) {
            if (65 <= c & c <= 90 || 97 <= c & c <= 122) {
                if ( c <= 77 || 97 <= c & c <= 109) {
                    c = (char) (c + 13);
                } else {
                    c = (char) (c - 13);
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
