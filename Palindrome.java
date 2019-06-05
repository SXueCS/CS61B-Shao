public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new ArrayDeque<>();
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            d.addLast(c);
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return isPalindromeHelper(d);
    }
    private boolean isPalindromeHelper(Deque<Character> d) {
        if (d.size() == 1 || d.size() == 0) {
            return true;
        } else {
            if (d.removeFirst() != d.removeLast()) {
                return false;
            }
            return isPalindromeHelper(d);
        }
    }
}
