package net.slipp.service.user;

import java.sql.SQLException;

import net.slipp.dao.user.UserDao;
import net.slipp.domain.user.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@Mock
	private UserDao userDao;
	
	@Test
	public void create_정상() throws Exception {
		User user = createUser();
		UserDao userDao = new UserDao() {
			@Override
			public void save(User user) throws SQLException {
			}

			@Override
			public User findByUserId(String userId) {
				return null;
			}
		};
		UserService userService = new UserService(userDao);
		userService.create(user);
	}

	private User createUser() {
		User user = new User();
		user.setUserId("userId");
		user.setPassword("password");
		user.setName("이름");
		user.setEmail("javajigi@gmail.com");
		return user;
	}

	@Test(expected=ExistedUserException.class)
	public void create_이미_존재하는_사용자() throws Exception {
		final User user = createUser();
		UserDao userDao = new UserDao() {
			@Override
			public void save(User user) throws SQLException {
			}
			
			@Override
			public User findByUserId(String userId) {
				return user;
			}
		};
		UserService userService = new UserService(userDao);
		userService.create(user);
	}
}