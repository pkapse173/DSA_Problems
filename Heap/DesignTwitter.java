//Problem: Design Twitter
/*
 * Input: ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
 *       
 * OUTPUT: [null, null, [5], null, null, [6, 5], null, [5]]
 * 
 */

/*
 * Approach - Priority Queue
    postTweet(int userId, int tweetId): Time O(1), Space O(1)
    getNewsFeed(int userId): Time O(n log k), Space O(k)
    follow(int followerId, int followeeId): Time O(1), Space O(1)
    unfollow(int followerId, int followeeId): Time O(1), Space O(1)
 */
package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {

    private static int timestamp = 0;
    private Map<Integer, User> userMap;
    
    public DesignTwitter() {
        userMap = new HashMap<>();  
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        
        Set<Integer> users = userMap.get(userId).follows;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        
        for (int user : users) {
            Tweet t = userMap.get(user).tweetHead;
            if (t != null) {
                pq.add(t);
            }
        }
        
        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            if (t.next != null) {
                pq.add(t.next);
            }
        }
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId, new User(followerId));
        }
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId)){
            userMap.get(followerId).unfollow(followeeId);
        }
    }
    
    public static int getTimestamp() {
        return timestamp++;
    }
}

class Tweet {
    public int id;
    public int time;
    public Tweet next;

    public Tweet(int id) {
        this.id = id;
        this.time = DesignTwitter.getTimestamp();
        this.next = null;
    }
}

class User {
    public int id;
    public Set<Integer> follows;
    public Tweet tweetHead;

    public User(int id) {
        this.id = id;
        follows = new HashSet<>();
        follows.add(id); // Follow itself
        tweetHead = null;
    }

    public void follow(int userId) {
        follows.add(userId);
    }

    public void unfollow(int userId) {
        if (userId != this.id) {
            follows.remove(userId);
        }
    }

    public void post(int tweetId) {
        Tweet t = new Tweet(tweetId);
        t.next = tweetHead;
        tweetHead = t;
    }
}

