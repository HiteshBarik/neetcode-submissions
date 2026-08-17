class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            //Remove from stack & calc if current temp is greater than top
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            //Push the new temp everytime for new top
            stack.push(new int[]{t, i});
        }
        return res;
    }
}
