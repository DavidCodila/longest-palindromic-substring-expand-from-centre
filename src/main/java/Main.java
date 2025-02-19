import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
    public static String longestPalindrome(String s) {
        ValidateUserInput.validate(s);
        int size = s.length();
        if (size <= 1) {
            return s;
        }
        char[] userInput = s.toCharArray();
        char[] temp = Arrays.copyOfRange(userInput,0, 1);
        for (int i = 0; i < size - 1; i++) {
            char[] oddSizedPalindrome = getLongestPalindromeFromCentreValue(i, i, userInput);
            char[] evenSizedPalindrome = getLongestPalindromeFromCentreValue(i, i + 1, userInput);

            if (oddSizedPalindrome.length > temp.length) {
                temp = oddSizedPalindrome;
            }
            if (evenSizedPalindrome.length > temp.length) {
                temp = evenSizedPalindrome;
            }
        }
        return String.valueOf(temp);
    }

    private static char[] getLongestPalindromeFromCentreValue(int left, int right, char[] s) {
        int size = s.length;
        while (left >= 0 && right < size && s[left] == s[right]) {
            left--;
            right++;
        }
        return Arrays.copyOfRange(s, left + 1, right);
    }
}
