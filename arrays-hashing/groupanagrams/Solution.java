import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Sort the anagram letters and put in the hashmap check accordingly and 
 */

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> anagramMap = new HashMap<>();

        for (int i = 0; i < strs.length; ++i) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedChars = new String(chars);
            ArrayList<String> wordsGrp = anagramMap.getOrDefault(sortedChars, new ArrayList<>());
            wordsGrp.add(strs[i]);
            anagramMap.put(sortedChars, wordsGrp);
        }

        List<List<String>> res = new ArrayList<>();

        for (Map.Entry<String, ArrayList<String>> entry : anagramMap.entrySet()) {
            res.add(entry.getValue());
        }

        return res;

    }
}