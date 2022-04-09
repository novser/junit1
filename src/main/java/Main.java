import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);

        validateUser(user);

        System.out.println("Доступ предоставлен");
    }

    public static User[] getUsers() {
        User user1 = new User("Viktor", "iAmUser", "viktor@gmail.com", 50);
        User user2 = new User("Anna", "passIs6Stars", "ioexeption@ya.ru", 21);
        User user3 = new User("Anton", "******", "parapa@mail.com", 16);
        User user4 = new User("Max", "racer", "redb@gmail.com", 33);
        return new User[]{user1, user2, user3, user4};
    }

    public static User getUserByLoginAndPassword(String login, String password) {
        User[] users = getUsers();
        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("User is still too young");
        }
    }
}
