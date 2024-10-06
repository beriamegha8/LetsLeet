class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        //ensuring sentence1 is the shorter or equal-length sentence
        if (words1.length > words2.length) {
            String[] temp = words1;
            words1 = words2;
            words2 = temp;
        }
        
        int prefixMatch = 0;
        while (prefixMatch < words1.length && words1[prefixMatch].equals(words2[prefixMatch])) {
            prefixMatch++;
        }
        
        int suffixMatch = 0;
        // Count matching words from the end
        while (suffixMatch < words1.length && words1[words1.length - 1 - suffixMatch].equals(words2[words2.length - 1 - suffixMatch])) {
            suffixMatch++;
        }
        
        return (prefixMatch + suffixMatch) >= words1.length;
    }
}
