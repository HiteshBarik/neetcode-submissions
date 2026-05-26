class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int difference = target - current;
            if(valMap.containsKey(difference)) {
                return new int[]{valMap.get(difference), i};
            }
            valMap.put(nums[i], i);
        }
        return new int[] {};
    }
}
