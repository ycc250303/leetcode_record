import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int vaild = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    vaild++;
                }
            }

            if (right - left > s1.length()) {
                char d = s2.charAt(left);
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        vaild--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }

            if (vaild == need.size()) {
                return true;
            }

        }
        return false;
    }
}