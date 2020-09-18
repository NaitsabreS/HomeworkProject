package exercise1;

public class CaesarCode {
    // initialized only on class instantiation
    // so multiple method invocations will append to
    // previous result
    StringBuilder stringBuilder = new StringBuilder();

    // does it encrypt or decrypt?
    // "or" or "and" in method name is a clear
    // indicator that those behaviors should be
    // separated. *Especially* when they're complete
    // opposites like here
    public String encryptOrDecrypt(String input) {
        char[] inputArray = input.toCharArray();
        for (char c : inputArray) {
            // non-descriptive condition, should have been extracted to method
            if (65 <= c &/* did you mean "&&" ? */ c <= 90 || 97 <= c & c <= 122) {
                // same as above
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
