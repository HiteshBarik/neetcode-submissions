class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        int l=0, res=0;
        int maxFreq = 0;

        for(int r = 0; r < s.length(); r++) {
            countMap.put(s.charAt(r), countMap.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, countMap.get(s.charAt(r)));

            while((r-l+1) - maxFreq > k) {
                countMap.put(s.charAt(l), countMap.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
