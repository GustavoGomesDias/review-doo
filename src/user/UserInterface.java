package user;

public interface UserInterface {
  UserInterface generateUser();
  UserInterface updateUser(String name, String email, String password);
  UserInterface deleteUser(int id);
  UserInterface login(String email, String password);
}
