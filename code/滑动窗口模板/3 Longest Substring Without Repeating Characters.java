import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, ans = 0;
        Set<Character> st = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            while (st.contains(c)) {
                char d = s.charAt(left);
                st.remove(d);
                left++;
            }
            ans = right - left + 1 > ans ? right - left + 1 : ans;
            st.add(c);
            right++;
        }
        return ans;
    }
}