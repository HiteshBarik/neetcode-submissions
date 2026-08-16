class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n = nums.length;
      int[] output = new int[n - k + 1];
      Deque<Integer> q = new LinkedList<>();
      int l = 0, r = 0;

      while (r < n) {
        //Monotonic Decreasing Queue
        //Always stores the highest on the leftmost side
        // Right side can have have lesser values
        while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
            q.removeLast();
        }
        // Remove indices that are outside the window
        q.addLast(r);
        if(l > q.getFirst()) {
            q.removeFirst();
        }
        if((r+1) >= k) {
            output[l] = nums[q.getFirst()];
            l++;
        }
        r++;
      }
      return output;
    }
}
