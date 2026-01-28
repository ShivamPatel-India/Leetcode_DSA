class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;
    Tweet(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }

    public int compareTo(Tweet that) {
        return that.time - this.time;
    }
}

class User {
    int userId;
    HashSet<Integer> followees;
    List<Tweet> tweets;
    User(int userId) {
        this.userId = userId;
        followees = new HashSet<>();
        followees.add(userId);
        tweets = new LinkedList<>();
    } 
    public void addTweet(Tweet tweet) {
        tweets.add(0, tweet);
    }
    public void addFollowee(int followeeId) {
        followees.add(followeeId);
    }
    public void removeFollowee(int followeeId) {
        followees.remove(followeeId);
    }


}
class Twitter {
    HashMap<Integer, User> userMap;
    int timeCounter;
    public Twitter() {
        userMap = new HashMap<>(0);
        timeCounter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if(!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }

        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)) return new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>();

        User user = userMap.get(userId);
        for(int followee: user.followees) {
            int count = 0;
            for(Tweet tweet: userMap.get(followee).tweets) {
                pq.offer(tweet);
                count++;
                if(count > 10) break;
            }
        }
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty() && index < 10) {
            res.add(pq.poll().tweetId);
            index++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) userMap.put(followerId, new User(followerId));
        if(!userMap.containsKey(followeeId)) userMap.put(followeeId, new User(followeeId));

        User user = userMap.get(followerId);
        user.addFollowee(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;

        User user = userMap.get(followerId);
        user.removeFollowee(followeeId);
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