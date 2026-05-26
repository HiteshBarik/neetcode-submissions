class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums) {
            numSet.add(num);
        }

        int maxSeq = 0;
        for(int num: numSet) {
            if(!numSet.contains(num - 1)) {
                int curLength = 1;
                while(numSet.contains(num + curLength)) {
                    curLength++;
                }
                maxSeq = Math.max(maxSeq, curLength);
            }
        }
        return maxSeq;
    }
}
