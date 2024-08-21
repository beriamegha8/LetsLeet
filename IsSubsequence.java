class Solution {
    public boolean isSubsequence(String s, String t) {
        int s_index = 0;
        int t_index = 0;
        int s_len = s.length();
        int t_len = t.length();

        while (s_index < s_len && t_index < t_len) {
            if (s.charAt(s_index) == t.charAt(t_index)) {
                s_index++;
            }
            t_index++;
        }

        return s_index == s_len;
    }
}
