package com.zhaiyz.redis.repository;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhaiyz.redis.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserRepositoryTest extends TestCase {

    @Resource
    private UserRepository userRepository;

    @Test
    public void testPut() {
        User user1 = new User("1", "user 1");
        User user2 = new User("2", "user 2");

        userRepository.put(user1);
        userRepository.put(user2);

        System.out.println(userRepository.getObjects());
        Assert.assertNotNull(userRepository.getObjects());
    }

    @Test
    public void testGet() {
        User user = new User();
        user.setId("1");

        System.out.println(userRepository.get(user));
        Assert.assertNotNull(userRepository.get(user));
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setId("2");
        
        userRepository.delete(user);
        System.out.println(userRepository.getObjects());
    }

    @Test
    public void testGetObjects() {
        System.out.println(userRepository.getObjects());
    }

}
