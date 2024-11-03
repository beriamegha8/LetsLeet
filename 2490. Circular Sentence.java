class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            String nextWord = words[(i + 1) % words.length];
            if (currentWord.charAt(currentWord.length() - 1) != nextWord.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
