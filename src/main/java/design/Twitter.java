package design;

import java.util.*;

public class Twitter {
    //单一时间线，不必考虑并发
    static int timestamp;
    Map<Integer, User> userMap;

    public Twitter() {
        timestamp = 0;
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        User user;
        if (!userMap.containsKey(userId)) {
            user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).postTweet(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) -> (b.time - a.time));
        //遍历所有的跟随者
        for (int id :
                userMap.get(userId).follower) {
            Tweet head = userMap.get(id).head;
            if (head != null) {
                queue.add(head);
            }
        }

        while (!queue.isEmpty()) {
            Tweet twt = queue.poll();
            if (res.size() == 10) {
                break;
            }
            res.add(twt.id);
            if (twt.next != null) {
                queue.add(twt.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User follower = new User(followerId);
            userMap.put(followerId, follower);
        }
        if (!userMap.containsKey(followeeId)) {
            User followee = new User(followeeId);
            userMap.put(followeeId, followee);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User follower = new User(followerId);
            userMap.put(followerId, follower);
        }
        if (!userMap.containsKey(followeeId)) {
            User followee = new User(followeeId);
            userMap.put(followeeId, followee);
        }
        userMap.get(followerId).unfollow(followeeId);
    }

    class Tweet {
        int id;//推特内容
        int time;
        Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    class User {
        int id;
        //关注的人
        Set<Integer> follower;
        Tweet head;

        public User(int userId) {
            id = userId;
            follower = new HashSet<>();
            head = null;
            follow(id);//关注自己
        }

        public void postTweet(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            //头插法
            tweet.next = head;
            head = tweet;
        }


        public void follow(int followeeId) {
            follower.add(followeeId);
        }

        public void unfollow(int followeeId) {
            if (followeeId != id) {
                follower.remove(followeeId);
            }
        }
    }
}




