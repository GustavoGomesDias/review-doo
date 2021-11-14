package user;

public class UserFactory {
  public UserInterface makeUser(String name, String email, String password, String role) {
    if (role.equals("admin")) {
      Admin admin = new Admin(name, email, password);
      return admin.generateUser();
    }
    User user = new User(name, email, password);
    return user.generateUser();
  }
}
