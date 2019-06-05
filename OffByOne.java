public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int diff = y - x;
        if (Math.abs(diff) == 1) {
            return true;
        } return false;
    }

    public boolean isPalindrome(String word) {
        Palindrome cc = new Palindrome();
        Deque<Character> d = cc.wordToDeque(word);

        return isPalindromeHelper(d);
    }
    private boolean isPalindromeHelper(Deque<Character> d) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        } else {
            if (!equalChars(d.removeFirst(), d.removeLast())) {
                return false;
            }
        }
        return isPalindromeHelper(d);
    }
}
