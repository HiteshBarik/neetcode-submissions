class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seenNumbers = new HashSet<>();
        for(int number: nums) {
            if(seenNumbers.contains(number)) {
                return true;
            }
            seenNumbers.add(number);
        }
        return false;
    }
}