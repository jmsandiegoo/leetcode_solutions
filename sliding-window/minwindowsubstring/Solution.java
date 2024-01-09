import java.util.HashMap;

class Solution {
    public boolean isAllCharIncluded(HashMap<Character, Integer> currTFreqMap) {
        for (Integer v: currTFreqMap.values()) { // O(52) == O(1)
            if (v > 0) return false;
        }
        return true;
    }
    
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tFreqMap = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            tFreqMap.put(c, tFreqMap.getOrDefault(c, 0) + 1);
        }

        int leftPtr = 0;
        int rightPtr = 0;
        int minWindow = (int) Math.pow(10, 5);
        String res = "";
        while (rightPtr < s.length()) {
            if (tFreqMap.containsKey(s.charAt(rightPtr))) {
                tFreqMap.put(s.charAt(rightPtr), tFreqMap.get(s.charAt(rightPtr)) - 1);
            }

            while (leftPtr <= rightPtr && isAllCharIncluded(tFreqMap)) { // at most O(N)
                if (rightPtr - leftPtr + 1 < minWindow) {
                    minWindow = rightPtr - leftPtr + 1;
                    res = s.substring(leftPtr, rightPtr + 1);
                };
                if (tFreqMap.containsKey(s.charAt(leftPtr)))
                    tFreqMap.put(s.charAt(leftPtr), tFreqMap.get(s.charAt(leftPtr)) + 1);
                ++leftPtr;
            }

            ++rightPtr;
        }
        
        return res;
    }
}