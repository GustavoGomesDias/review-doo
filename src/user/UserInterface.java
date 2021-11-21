package user;

/*
* private String name;
  private String email;
  private String password;
* */

import comments.Comments;

public interface UserInterface {
  UserInterface generateUser();
  UserInterface updateUser(String name, String email, String password);
  UserInterface deleteUser(int id);
  UserInterface login(String email, String password);

  void setName(String name);
  String getName();
  void setEmail(String email);
  String getEmail();
  void setPassword(String password);
  String getPassword();
  void setRole(String role);
  String getRole();
  String createComment(String email, String comment, int companyId);
  String createReply(String content, Comments origin);
}
