public class Palindrome {
	public Deque<Character> wordToDeque(String word) {
		Deque<Character> deque = new LinkedListDeque<>();
		for (Character c : word.toCharArray()) {
			deque.addLast(c);
		}
		return deque;
	}

	public boolean isPalindrome(String word) {
		word = word.toLowerCase();
		if (word.length() == 0 || word.length() == 1) {
			return true;
		} else {
			return word.charAt(0) == word.charAt(word.length() - 1) && isPalindrome(word.substring(1, word.length() - 1));
		}
	}

	public boolean isPalindrome(String word, CharacterComparator cc) {
		word = word.toLowerCase();
		if (word.length() == 0 || word.length() == 1) {
			return true;
		} else {
			return cc.equalChars(word.charAt(0), word.charAt(word.length() - 1)) && isPalindrome(word.substring(1, word.length() - 1), cc);
		}
	}
}
