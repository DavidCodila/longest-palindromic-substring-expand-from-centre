public class ValidateUserInput {
    public static void validate (String s) {
        if (s == null || s.contains("\0") || s.isBlank()) {
            throw new RuntimeException("Input can not be less then 1 character");
        }
        if (s.length() > 1000) {
            throw new RuntimeException("Input can not be greater then 1000 characters");
        }
        if (!s.matches("[a-zA-Z0-9 ]*")) {
            throw new RuntimeException("Input can not contain special characters");
        }
        if (s.contains(" ")) {
            throw new RuntimeException("Input can not contain whitespaces");
        }
    }
}
