/*
* left and right pointer
* frequency of the of the seen letters if k reaches 0 that is the max window size 
* and move the start accordingly. how do we move the start? we can move it to next unique element
* how do we count the frequency of the letters and see the differences from the most consecutive letter?
*   - thinking of hashmap containing the frequency of each letter occurence, each update will check current main letter
*   - we can have a total counter of elements and subtract with primary make sure its <= k
*/

import java.util.HashMap;
import java.util.Queue;
import java.util.TreeSet;

class Tuple implements Comparable<Tuple> {
    int x; // freq
    char y; // char
    Queue<Integer> idxs; // idxs

    public Tuple(int x, char y, Queue<Integer> idxs) {
        this.x = x;
        this.y = y;
        this.idxs = idxs;
    }

    @Override
    public int compareTo(Tuple o) {
        return this.x - o.x;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        TreeSet<Tuple> freqTree = new TreeSet<>();
        HashMap<Character, Tuple> refMap = new HashMap<>();
        int leftPtr = 0;
        int rightPtr = 0;
        int windowSize = 0;
        while(rightPtr < s.length()) {
            if (!freqTree.contains(refMap.get(s.charAt(rightPtr)))) {
                
            }
        }
    }
}