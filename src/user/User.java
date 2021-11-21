package user;

import comments.*;
import company.Company;

import java.util.Random;

public class User implements UserInterface{
  private int id;
  private String name;
  private String email;
  private String password;
  private String role = "admin";

  public User(String name, String email, String password) {
    this.id = new Random().nextInt();
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

  public int getId() { return this.id; }

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


  public String createComment(String email, String comment, int companyId) {
    Comments comments = new Comments(comment);
    // Salva no banco, como algo relacionado a uma company
    return comments.getTemporaryCode();
  }

  public String createReply(String content, Comments origin) {
    return origin.addReply(content);
  }

  public String createCompanyRequest(String name, int imageId) {
    Company company = new Company(name, imageId);
    // Salva como pedido de criar uma nova empresa
    boolean result = true;
    if (result) return "Pedido criado com sucesso!";
    return "Erro ao criar um pedido";
  }

  public String deleteComment(int commentId, String temporaryCode) {
    String[] db = new String[2]; // Representação do db
    int dbId = new Random().nextInt();
    db[0] = "content"; // Representação do db
    db[1] = "temporaryCode"; // Representação do db
    Comments comments = new Comments(db[0]); // pesquisa o comentário no banco e cria uma instância
    comments.setTemporaryCode(temporaryCode);
    comments.setId(dbId);
    if (commentId == comments.getId() && temporaryCode.equals(comments.getTemporaryCode())) {
      // delete
      return "Comentário deletado com sucesso!";
    }
    return "Comentário não encontrado!";
  }

  public Company evaluate(int value, String featEvaluated) {
    return new Company("", 0);
  }
}
