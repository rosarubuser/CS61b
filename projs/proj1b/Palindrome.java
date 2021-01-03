public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
             res.addLast(word.charAt(i));
        }
         return res;
    }

    // iteration
/*    public boolean isPalindrome(String word) {
        Deque<Character> wordDeq = wordToDeque(word);
        while (!wordDeq.isEmpty() && wordDeq.size() != 1) {
            if (wordDeq.removeFirst() != wordDeq.removeLast()) {
                return false;
            }
        }
        return true;
    }*/

    /**
     * to judge whether a word is palindrome using recursion
     */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeq = wordToDeque(word);
        return isPalindromeHelper(wordDeq);
    }

    private boolean isPalindromeHelper(Deque<Character> word) {
        if (word.isEmpty() || word.size() == 1)
            return true;
        return word.removeFirst() == word.removeLast() && isPalindromeHelper(word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeq = wordToDeque(word);
        return isPalindromeHelper(wordDeq, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> word, CharacterComparator cc) {
        if (word.isEmpty() || word.size() == 1)
            return true;
        return cc.equalChars(word.removeFirst(), word.removeLast()) && isPalindromeHelper(word, cc);
    }
}
