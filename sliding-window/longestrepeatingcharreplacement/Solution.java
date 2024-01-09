/* 
* left and right pointer
* frequency of the of the seen letters if k reaches 0 that is the max window size
* and move the start accordingly. how do we move the start? we can move it to next unique element
* how do we count the frequency of the letters and see the differences from the most consecutive letter?
*   - thinking of hashmap containing the frequency of each letter occurence, each update will check current main letter
*   - we can have a total counter of elements and subtract with primary make sure its <= k
*/
import java.util.HashMap;
import java.util.Map;

class Solution {
    public char getMostFreqChar(HashMap<Character, Integer> map) {
        char maxChar = 0;
        int currMax = -1;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) { // O(26) = O(1)
            if (entry.getValue() > currMax) {
                currMax = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        return maxChar;
    }

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> refMap = new HashMap<>();
        int leftPtr = 0;
        int rightPtr = 0;
        int currMaxWinSize = -1;
        while(rightPtr < s.length()) { // amortised O(N)
            int winSize = rightPtr - leftPtr + 1;
            refMap.put(s.charAt(rightPtr), refMap.getOrDefault(s.charAt(rightPtr), 0) + 1);
            char mostFreqChar = getMostFreqChar(refMap);
            if (winSize - refMap.get(mostFreqChar) > k) {
                while (true) { // at most N times
                    char currFreqChar = getMostFreqChar(refMap);
                    if (refMap.isEmpty() || leftPtr == rightPtr || winSize - refMap.get(currFreqChar) <= k)
                        break;
                    refMap.put(s.charAt(leftPtr), refMap.get(s.charAt(leftPtr)) - 1);
                    ++leftPtr;
                    winSize = rightPtr - leftPtr + 1;
                }
            }
            if (winSize > currMaxWinSize) {
                currMaxWinSize = winSize;
            }
            ++rightPtr;
        }
        
        return currMaxWinSize;
    }
}