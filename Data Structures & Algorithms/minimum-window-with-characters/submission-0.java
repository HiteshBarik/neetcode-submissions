class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty() || s.isEmpty() || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int have = 0, need = countT.size();
        int l = 0;
        int[] ans = {-1, 0, 0};

        for(int r =0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }
            while(have == need) {
                if(r - l + 1 < ans[0] || ans[0] == -1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        return ans[0] != -1 ? s.substring(ans[1], ans[2]+1) : "";
    }
}
