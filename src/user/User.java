package user;

import comments.*;

public class User implements UserInterface{

  private String name;
  private String email;
  private String password;
  private String role = "admin";
  private final CommentsDirector commentsDirector = new CommentsDirector();
  private Comments comments = new Comments();

  public User(String name, String email, String password) {
    this.setName(name);
    this.setEmail(email);
    this.setPassword(password);
  }

  @Override
  public UserInterface generateUser() {
    // salva no banco
    return this;
  }

  @Override
  public UserInterface updateUser(String name, String email, String password) {
    if (name != null) this.name = name;
    if (email != null) this.email = email;
    if (password != null) this.password = password;
    // Salva no banco
    return this;
  }


  // Acredito que essa precisaria do framework/banco de dados
  @Override
  public UserInterface deleteUser(int id) {
    return null;
  }

  // Acredito que essa precisaria do framework/banco de dados
  @Override
  public UserInterface login(String email, String password) {
    return null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String createComments(String content) {
    CommentsDirector director = new CommentsDirector();
    this.comments = director.builderComments(content);
    return comments.getTemporaryCode();
  }

  public String createReply(String content) {
    CommentsDirector director = new CommentsDirector();
    Comments reply = director.builderReply(content, this.comments);
    return reply.getTemporaryCode();
  }

  public void deleteComments(String temporaryCode) {
    this.comments.deleteComments(temporaryCode);
  }
}
