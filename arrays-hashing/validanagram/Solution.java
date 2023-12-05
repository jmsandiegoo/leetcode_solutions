/*
* Hashmap to contain all the letters of input
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> letterMap = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            letterMap.put(s.charAt(i), letterMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); ++i) {
            int freq = letterMap.getOrDefault(t.charAt(i), 0);
            if (freq <= 0)
                return false;
            letterMap.put(t.charAt(i), freq - 1);
        }

        for (Map.Entry<Character, Integer> entry : letterMap.entrySet()) {
            if (entry.getValue() > 0)
                return false;
        }

        return true;
    }
}