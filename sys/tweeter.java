public class MiniTwitter {

    Map<Integer, Map<Integer, Boolean>> friends;
    Map<Integer, List<Node>> user_tweets;
    int order;
    class Node {
            public int order;
            public Tweet tweet;
            public Node(int ord, Tweet t) {
                this.order = ord;
                this.tweet = t;
            }
        }
    public MiniTwitter() {
        // initialize your data structure here.
        this.order = 0;
        this.friends = new HashMap<Integer, Map<Integer, Boolean>>();
        this.user_tweets = new HashMap<Integer, List<Node>>();
    }
//descend sort
    class SortByOrder implements Comparator {
        public int compare(Object n1, Object n2) {
            Node node1 = (Node)n1;
            Node node2 = (Node)n2;
            if (node1.order < node2.order) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        Tweet tweet = Tweet.create(user_id, tweet_text);
        if (!user_tweets.containsKey(user_id)) {
            user_tweets.put(user_id, new ArrayList<Node>());
        } 
        order++;
        user_tweets.get(user_id).add(new Node(order, tweet));
        return tweet;
    }
     
    public List<Node> getLastTen(List<Node> temp) {
        int num = 10;
        if (temp.size() < 10) {
            num = temp.size();
        }
        return temp.subList(temp.size() - num, temp.size());
    }
    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        List<Node> temp = new ArrayList<Node>();
        if (user_tweets.containsKey(user_id)) {
            temp.addAll(getLastTen(user_tweets.get(user_id)));
        }
        if (friends.containsKey(user_id)) {
            for (Map.Entry<Integer, Boolean> entry : friends.get(user_id).entrySet()) {
                int user = entry.getKey();
                if (user_tweets.containsKey(user)) {
                    temp.addAll(getLastTen(user_tweets.get(user)));
                }
            }
        }
        Collections.sort(temp, new SortByOrder());
        List<Tweet> res = new ArrayList<Tweet>();
        temp = getLastTen(temp);
        for (Node n : temp) {
          res.add(n.tweet);  
        }
        return res;
    }
        
    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        List<Node> temp = new ArrayList<Node>();
        if (user_tweets.containsKey(user_id)) {
            temp.addAll(getLastTen(user_tweets.get(user_id)));
        }
        Collections.sort(temp, new SortByOrder());
        List<Tweet> res = new ArrayList<Tweet>();
        temp = getLastTen(temp);
        for (Node n : temp) {
          res.add(n.tweet);  
        }
        return res;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!friends.containsKey(from_user_id)) {
            friends.put(from_user_id, new HashMap<Integer, Boolean>());
        }
        friends.get(from_user_id).put(to_user_id, true);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (friends.containsKey(from_user_id)) {
            friends.get(from_user_id).remove(to_user_id);
        }
    }
}
