class Solution {
    public int maxArea(int[] heights) {
        int l = 0, result = 0;
        int r = heights.length - 1;
        while(l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            result = Math.max(result, area);
            if(heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
