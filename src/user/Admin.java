package user;

public class Admin implements UserInterface {
  private String name;
  private String email;
  private String password;
  private String role = "admin";

  public Admin(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
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
    // salva no banco
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
}
