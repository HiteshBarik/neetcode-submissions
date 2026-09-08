class Twitter {

    private Map<Integer, List<Integer>> userTweets;
    private Map<Integer, Set<Integer>> userFollowing;
    private Map<Integer, Integer> tweets;
    private int time;

    public Twitter() {
       userTweets = new HashMap<>();
       userFollowing = new HashMap<>();
       tweets = new HashMap<>();
       time = 0; 
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k->new ArrayList()).add(tweetId);
        tweets.put(tweetId, ++time);
    }
    
    public List<Integer> getNewsFeed(int userId) {
       Set<Integer> following = userFollowing.getOrDefault(userId, new HashSet<>());
       Set<Integer> users = new HashSet<>(following);
       users.add(userId);

       PriorityQueue<Integer> pq = new PriorityQueue<>(10, (a, b) -> (tweets.get(b) - tweets.get(a)));
       for(Integer u : users) {
        List<Integer> userTweet = userTweets.get(u);
        if(userTweet != null && !userTweet.isEmpty()) {
            for(int i = userTweet.size() - 1, k = 10; i >=0 && k > 0; --i, --k) {
                pq.offer(userTweet.get(i));
            }
        }
       }
       List<Integer> res = new ArrayList<>();
       while(!pq.isEmpty() && res.size() < 10) {
        res.add(pq.poll());
       }
       return res; 
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowing.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
 
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowing.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);

    }
}
