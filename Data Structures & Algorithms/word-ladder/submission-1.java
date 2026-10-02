class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> words = new HashSet<>(wordList);
        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String node = q.poll();
                if(node.equals(endWord)) return res;
                for(int j = 0; j < node.length(); j++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == node.charAt(j)) continue;
                        String nei = node.substring(0, j) + c + node.substring(j + 1);
                        if(words.contains(nei)) {
                            q.offer(nei);
                            words.remove(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
