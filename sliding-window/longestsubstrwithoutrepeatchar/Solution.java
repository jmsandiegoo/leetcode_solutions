/*
 * sliding window start of unique sequence end of unique seq
 * have a hashset of all the str traversed by end ptr if in hashet
 * move start till dup elem removed
 */

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int leftPtr = 0;
        int rightPtr = 0;
        HashSet<Character> occurenceSet = new HashSet<>();
        while (rightPtr < s.length()) {
            if (occurenceSet.contains(s.charAt(rightPtr))) {
                res = rightPtr - leftPtr > res ? rightPtr - leftPtr : res;
                while (true) {
                    ++leftPtr;
                    if (s.charAt(leftPtr - 1) == s.charAt(rightPtr)) break; 
                    occurenceSet.remove(s.charAt(leftPtr - 1));
                }
            }
            occurenceSet.add(s.charAt(rightPtr));
            ++rightPtr;
        }
        res = rightPtr - leftPtr > res ? rightPtr - leftPtr : res;
        return res;
    }
}