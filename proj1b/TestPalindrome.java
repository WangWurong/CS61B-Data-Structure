import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        LinkedListDeque d = (LinkedListDeque) palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        boolean test1 = palindrome.isPalindrome("aabbaa");
        boolean test2 = palindrome.isPalindrome("abcd");
        boolean test3 = palindrome.isPalindrome("aba");
        boolean test4 = palindrome.isPalindrome("abA");
        assertTrue(test1);
        assertFalse(test2);
        assertTrue(test3);
        assertTrue(test4);
    }

    @Test
    public void testIsPalindromeOne() {
        boolean test1 = palindrome.isPalindrome("flake", offByOne);
        assertTrue(test1);
    }
}