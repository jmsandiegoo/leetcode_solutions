/*
 * can have one stack containing the opening
 */

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> parenStack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                parenStack.push(c);
            } else {
                if (parenStack.isEmpty() || !(parenStack.peek() == '(' && c == ')' || parenStack.peek() == '{' && c == '}' || parenStack.peek() == '[' && c == ']')) return false;
                char o = parenStack.pop();
            }
        }

        return true;
    }
}