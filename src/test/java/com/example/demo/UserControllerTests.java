package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import com.example.demo.models.User;
import com.example.demo.models.UserMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class UserControllerTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void testUserMapper() throws Exception {
		// insert一条数据，并select出来验证
		System.out.println("????");
		userMapper.insert("AAA", 20);
		System.out.println("????");
		User u = userMapper.findByName("AAA");
		assertEquals(20, u.getAge().intValue());
		// update一条数据，并select出来验证
		u.setAge(30);
		userMapper.update(u);
		u = userMapper.findByName("AAA");
		assertEquals(30, u.getAge().intValue());
		// 删除这条数据，并select验证
		userMapper.delete(u.getId());
		u = userMapper.findByName("AAA");
		assertEquals(null, u);
	}

	@Test
	@Rollback
	public void testUserMapperFindAllUsers() throws Exception {
		List<User> userList = userMapper.findAll();
		for (User user : userList) {
			assertEquals(null, user.getId());
			assertNotEquals(null, user.getName());
		}
	}

}