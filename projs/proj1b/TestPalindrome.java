import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("abc");
        String actual = "";
        for (int i = 0; i < "abc".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("abc", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("caac"));
        assertTrue(palindrome.isPalindrome("cadac"));
        assertFalse("The word is not palindrome", palindrome.isPalindrome("caAc"));
        assertFalse(palindrome.isPalindrome("cat"));
    }

    @Test
    public void testIsPalindromeWithOBO() {
        CharacterComparator obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("goph", obo));
        assertFalse(palindrome.isPalindrome("faaae", obo));
        assertTrue(palindrome.isPalindrome("", obo));
        assertTrue(palindrome.isPalindrome("a", obo));
        assertFalse(palindrome.isPalindrome("%a;", obo));
        assertTrue(palindrome.isPalindrome("%cd&", obo));
    }
}