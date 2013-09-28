package com.zhaiyz.redis.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.zhaiyz.redis.domain.User;

public class UserRepository implements Repository<User> {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Override
    public void put(User user) {
        redisTemplate.opsForHash().put(user.getObjectKey(), user.getKey(), user);
    }

    @Override
    public User get(User user) {
        return (User) redisTemplate.opsForHash().get(user.getObjectKey(), user.getKey());
    }

    @Override
    public void delete(User user) {
        redisTemplate.opsForHash().delete(user.getObjectKey(), user.getKey());
    }

    @Override
    public List<User> getObjects() {
        List<User> users = new ArrayList<User>();
        for (Object user : redisTemplate.opsForHash().values(User.OBJECT_KEY)) {
            users.add((User) user);
        }
        return users;
    }

    /**
     * @return the redisTemplate
     */
    public RedisTemplate<String, User> getRedisTemplate() {
        return redisTemplate;
    }

    /**
     * @param redisTemplate
     *            the redisTemplate to set
     */
    public void setRedisTemplate(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

}
