class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] inputChars = s.toCharArray(); // O(n)
        int ptr1 = 0;
        int ptr2 = inputChars.length - 1;
        while (ptr1 != ptr2) {
            if (ptr1 >= inputChars.length || ptr2 < 0) break;
            if (inputChars[ptr1] != inputChars[ptr2]) return false;
            ptr1++;
            ptr2--;
        }
        return true;
    }
}