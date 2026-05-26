class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sFreq = new HashMap<>();
        HashMap<Character, Integer> tFreq = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            sFreq.put(s.charAt(i), sFreq.getOrDefault(s.charAt(i), 0) + 1);
            tFreq.put(t.charAt(i), tFreq.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sFreq.equals(tFreq);
    }
}
