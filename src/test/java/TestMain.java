import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMain {

    @Test
    public void testLongestPalindrome_a() {
        assertEquals("a", Main.longestPalindrome("a"));
    }

    @Test
    public void testLongestPalindrome_ab() {
        assertEquals("a", Main.longestPalindrome("ab"));
    }

    @Test
    public void testLongestPalindrome_aba() {
        assertEquals("aba", Main.longestPalindrome("aba"));
    }

    @Test
    public void testLongestPalindrome_aaba() {
        assertEquals("aba", Main.longestPalindrome("aaba"));
    }

    @Test
    public void testLongestPalindrome_abaa() {
        assertEquals("aba", Main.longestPalindrome("abaa"));
    }

    @Test
    public void testLongestPalindrome_abccba() {
        assertEquals("abccba", Main.longestPalindrome("abccba"));
    }

    @Test
    public void testLongestPalindrome_abcdcba() {
        assertEquals("abcdcba", Main.longestPalindrome("abcdcba"));
    }

    @Test
    public void testLongestPalindrome_aaaabcdcbabbb() {
        assertEquals("abcdcba", Main.longestPalindrome("aaaabcdcbabbb"));
    }

    @Test
    public void testLongestPalindrome_abcdcbabbb() {
        assertEquals("abcdcba", Main.longestPalindrome("abcdcbabbb"));
    }

    @Test
    public void testLongestPalindromeNull() {
        var exception = assertThrows(
                RuntimeException.class,
                () -> Main.longestPalindrome(null)
        );
        assertEquals(exception.getMessage(),"Input can not be less then 1 character");
    }

    @Test
    public void testLongestPalindromeEmpty() {
        var exception = assertThrows(
                RuntimeException.class,
                () -> Main.longestPalindrome("")
        );
        assertEquals(exception.getMessage(),"Input can not be less then 1 character");
    }

    @Test
    public void testLongestPalindromeInputNullFilledCharArray() {
        String largeStringArray = Arrays.toString(new char[3]);
        largeStringArray = largeStringArray.replace("[", "");
        largeStringArray = largeStringArray.replace("]", "");
        final String largeInput = largeStringArray.replace(", ","");
        var exception = assertThrows(
                RuntimeException.class,
                () -> Main.longestPalindrome(largeInput)
        );
        assertEquals(exception.getMessage(),"Input can not be less then 1 character");
    }

    @Test
    public void testLongestPalindromeInputOver1000Characters() {
        char[] largeStringArray = new char[1001];
        Arrays.fill(largeStringArray, '1');
        String largeInput = Arrays.toString(largeStringArray);
        largeInput = largeInput.replace("[", "");
        largeInput = largeInput.replace("]", "");
        final String formattedLargeInput = largeInput.replace(", ","");
        var exception = assertThrows(
                RuntimeException.class,
                () -> Main.longestPalindrome(formattedLargeInput)
        );
        assertEquals(exception.getMessage(),"Input can not be greater then 1000 characters");
    }

    @Test
    public void testLongestPalindromeSpecialCharacters() {
        var exception = assertThrows(
                RuntimeException.class,
                () -> Main.longestPalindrome("???")
        );
        assertEquals(exception.getMessage(),"Input can not contain special characters");
    }

    @Test
    public void testLongestPalindromeSpaceInBetweenCharacters() {
        var exception = assertThrows(
                RuntimeException.class,
                () -> Main.longestPalindrome("ab cd")
        );
        assertEquals(exception.getMessage(),"Input can not contain whitespaces");
    }

}
