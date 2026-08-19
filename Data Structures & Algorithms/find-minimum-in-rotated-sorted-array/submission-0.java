class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while(l <= r) {
            // If the current search range is already sorted,
            // nums[l] is the smallest element in this range.
            //
            // Example:
            // [1, 2, 3, 4]
            //  ↑        ↑
            //  l        r
            //
            // Since nums[l] < nums[r], there is no rotation
            // inside this range.
            if(nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int m = l + (r - l)/2;
            /// The middle element could potentially be
            // the minimum, so include it in our result.
            res = Math.min(res, nums[m]);

            // If nums[m] >= nums[l], the LEFT portion
            // [l ... m] is sorted.
            //
            // Therefore, the minimum cannot be somewhere
            // before/equal to m (except m itself, which we
            // already checked).
            //
            // So search the right half.
            if(nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
