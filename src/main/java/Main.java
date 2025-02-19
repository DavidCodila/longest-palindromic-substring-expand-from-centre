public class Main {
    public static void main(String[] args) {

    }
    public static String longestPalindrome(String s) {
        ValidateUserInput.validate(s);
        if (s.length() <= 1) {
            return s;
        }

        String temp = s.substring(0, 1);
        int size = s.length();
        for (int i = 0; i < size - 1; i++) {
            String oddSizedPalindrome = getLongestPalindromeFromCentreValue(i, i, s);
            String evenSizedPalindrome = getLongestPalindromeFromCentreValue(i, i + 1, s);

            if (oddSizedPalindrome.length() > temp.length()) {
                temp = oddSizedPalindrome;
            }
            if (evenSizedPalindrome.length() > temp.length()) {
                temp = evenSizedPalindrome;
            }
        }
        return temp;
    }

    private static String getLongestPalindromeFromCentreValue(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
