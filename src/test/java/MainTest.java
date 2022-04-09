import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testGetUsers_validUsersList() {
        User user1 = new User("Viktor", "iAmUser", "viktor@gmail.com", 50);
        User user2 = new User("Anna", "passIs6Stars", "ioexeption@ya.ru", 21);
        User user3 = new User("Anton", "******", "parapa@mail.com", 16);
        User user4 = new User("Max", "racer", "redb@gmail.com", 33);
        User[] expected = new User[]{user1, user2, user3, user4};

        User[] result = Main.getUsers();

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testValidateUser_throwAccessDeniedException() {
        User exceptionUser = new User("user1", "1234", "test@test.ru", 17);

        Assertions.assertThrowsExactly(AccessDeniedException.class, () -> Main.validateUser(exceptionUser));
    }

    @Test
    public void getUserByLoginAndPassword() {
        User expected = new User("Viktor", "iAmUser", "viktor@gmail.com", 50);

        User result = Main.getUserByLoginAndPassword("Viktor", "iAmUser");

        Assertions.assertEquals(expected, result);
    }
}
