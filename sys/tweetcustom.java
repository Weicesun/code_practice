public class Twitter {

    /** Initialize your data structure here. */
    static int timestamp = 0;
    class tweet {
        int id;
        int time;
        tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    Map<Integer, List<tweet>> map;
    Map<Integer, List<Integer>> follower;
    
    public Twitter() {
        map = new HashMap<>();
        follower = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweet nt = new tweet(tweetId, timestamp);
        timestamp++;
        if (map.containsKey(userId)) {
            map.get(userId).add(nt);
        } else {
            List<tweet> list = new ArrayList<>();
            list.add(nt);
            map.put(userId, list);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<tweet> pq = new PriorityQueue<tweet>(10, new Comparator<tweet>() {
           public int compare (tweet a, tweet b) {
               return a.time - b.time;
           }
        });
        List<Integer> res = new ArrayList<>();
        List<Integer> tf = follower.get(userId);
        if (tf == null || tf.size() == 0) {
            tf = new ArrayList<>();
        }
        tf.add(userId);
        for (int user : tf) {
            List<tweet> tl = map.get(user);
            if (tl != null) {
                for (tweet nn : tl) {
                    pq.offer(nn);
                    if (pq.size() > 10) {
                        pq.poll();
                    }
                    
                }
            }
        }
        tf.remove(Integer.valueOf(userId));
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().id);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (follower.containsKey(followerId)) {
            if (follower.get(followerId).contains(followeeId)) {
                return;
            }
            follower.get(followerId).add(followeeId);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(followeeId);
            follower.put(followerId, list);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (follower.get(followerId) == null) {
            return;
        }
        follower.get(followerId).remove((Integer)followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
