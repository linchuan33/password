import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static boolean isPasswordValid(String password) {
        // Check length
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Check for at least three out of four categories
        int count = 0;
        if (password.matches(".*[a-z].*")) {
            count++;
        }
        if (password.matches(".*[A-Z].*")) {
            count++;
        }
        if (password.matches(".*\\d.*")) {
            count++;
        }
        if (password.matches(".*[~!@#$%^&*()\\-=_+].*")) {
            count++;
        }

        return count >= 3;
    }

    public static void main(String[] args) {
        // Test cases
        String[] passwords = {
                "Abcdefg1!",
                "abcdefgh",
                "ABCDEFGH",
                "12345678",
                "~!@#$%^&",
                "Abcdefg1"
        };

        for (String password : passwords) {
            System.out.println(password + " is valid: " + isPasswordValid(password));
        }
    }
}
