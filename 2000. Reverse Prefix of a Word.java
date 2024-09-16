class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        StringBuilder reversedPart = new StringBuilder(word.substring(0, index + 1));
        reversedPart.reverse();
        return reversedPart.toString() + word.substring(index + 1);
    }
}
