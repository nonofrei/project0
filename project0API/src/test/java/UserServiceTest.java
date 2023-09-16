import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserDAO userDAO;

    @InjectMocks
    UserService userService;

    @Test
    public void testInsertValidUser() {
        User testUser = new User("Test", "McTest", "username", "password");
        // Stubbing - when insertUser() is called from the DAO then return out user
        when(userDAO.insertUser(testUser)).thenReturn(testUser);
        // Call the service method,
        User returnedUser = userService.insertUser(testUser);
        // Verify the method was called and that it was called ONLY ONCE
        verify(userDAO, times(1)).insertUser(testUser);

        // ASSERTS
        // Make sure a not null object was returned.
        assertNotNull(returnedUser);
        // Make sure the returned user has the values we expect
        assertEquals(returnedUser.getUser_first_name(), "Test");
        assertEquals(returnedUser.getUser_last_name(), "McTest");
        assertEquals(returnedUser.getUser_username(), "username");
        assertEquals(returnedUser.getUser_password(), "password");
    }

    @Test(expected = IllegalArgumentException.class) // Checking for IllegalArgumentException being thrown
    public void testInsertInvalidUser() {
        User testUser = new User("", null, "", null);
        userService.insertUser(testUser); // All that is needed because insertUser() should throw "IllegalArgumentException"
    }

    @Test
    public void testGetAllUsers() {
        UserService realUserService = new UserService();
        ArrayList<User> testUsers = realUserService.getAllUsers();
        assertNotNull(testUsers);
        assertEquals(testUsers.get(0).getClass(), User.class);
    }

    @Test
    public void testGetAllUsersById() {
        UserService realUserService = new UserService();
        User testUser = realUserService.getUserById(1);
        assertNotNull(testUser);
        assertEquals(testUser.getClass(), User.class);
    }

    @Test
    public void testUpdateUserNameByUserId() {
        UserService realUserService = new UserService();
        User realUser = realUserService.getUserById(1);
        userService.updateUserNameByUserId(1, "Test2", "McTest2");
        // Check if method was called
        verify(userDAO, times(1)).updateUserNameByUserId(1, "Test2", "McTest2");
        // reset data
        realUserService.updateUserNameByUserId(realUser.getUser_id(), realUser.getUser_first_name(), realUser.getUser_last_name());
    }
}
