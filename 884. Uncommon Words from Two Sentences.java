import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        Set<String> once = new HashSet<>();
        Set<String> moreThanOnce = new HashSet<>();
        for (String word : words1) {
            if (!once.add(word)) {
                moreThanOnce.add(word);
            }
        }
        for (String word : words2) {
            if (!once.add(word)) {
                moreThanOnce.add(word);
            }
        }
        once.removeAll(moreThanOnce);
        return once.toArray(new String[0]);
    }
}
