/*
* two pointer front and back
* get the smallest height between two pointer and multipy by the i difference
* move the smaller ptr
*/

class Solution {
    public int maxArea(int[] height) {
        int ptr1 = 0;
        int ptr2 = height.length - 1;
        int maxArea = -1;
        while (ptr1 < ptr2) {
            int area = height[ptr1] < height[ptr2] ? height[ptr1] * (ptr2 - ptr1) : height[ptr2] * (ptr2 - ptr1);
            if (maxArea < area)
                maxArea = area;
            else if (height[ptr1] < height[ptr2])
                ++ptr1;
            else
                --ptr2;
        }

        return maxArea;
    }
}