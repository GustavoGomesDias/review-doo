package user;

import comments.Comments;
import company.Category;
import company.Company;

import java.util.ArrayList;
import java.util.Random;

public class Admin implements UserInterface {
  private int id;
  private String name;
  private String email;
  private String password;
  private String role = "admin";

  public Admin(String name, String email, String password) {
    this.id = new Random().nextInt();
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

  @Override
  public String createComment(String email, String comment, int companyId) {
    Comments comments = new Comments(comment);
    // Salva no banco, como algo relacionado a uma company
    return comments.getTemporaryCode();
  }

  @Override
  public String createReply(String content, Comments origin) {
    return origin.addReply(content);
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Company acceptCreateCompanyRequest(Company company) {
    return company;
  }

  public void acceptCreateCompanyRequest() {
  }

  public ArrayList<Company> getAllCampanies() {
    return new ArrayList<Company>();
  }

  public void deleteComment() {
  }

  public Category createCategory(String name, String description) {
    Category category = new Category(name, description);
    // salva
    return category;
  }

  public UserInterface banUser(int id, String reason) {
    // procura o user pelo id no banco
    // seta como banido
    return this; // retorna o user atualizado
  }

  public UserInterface unBanUser(int id, String reason) {
    // procura o user pelo id no banco
    // seta como desbanido
    return this; // retorna o user atualizado
  }

  public Category getCategory(int categoryId) {
    // procura a categoria pelo id;
    return new Category("", ""); // retorna ela
  }

  public ArrayList<Category> getAllCategory() {
    // pega todas as categoria no banco
    // adiciona elas ao array
    return new ArrayList<Category>(); // Retorna o array
  }

  public String deleteCategory(int categoryId) {
    boolean deleted = false; // representação da resposta do banco
    // procura no banco e deleta
    // deleta, se o retorno for true
    if (deleted) return "Houve um erro na deleção, tente novamente";
    return "Deletado com sucesso!";
  }

  public Company getCompany(int companyId) {
    // procura a empresa pelo nome (ou id);
    return new Company("", 0); // representação, apenas
  }

  public ArrayList<Company> getAllCompany() {
    // pega todas as categoria no banco
    // adiciona elas ao array
    return new ArrayList<Company>(); // Retorna o array
  }

  public String deleteCompany(int companyId) {
    boolean deleted = false; // representação da resposta do banco
    // procura no banco e deleta
    // deleta, se o retorno for true
    if (deleted) return "Houve um erro na deleção, tente novamente";
    return "Deletado com sucesso!";
  }

  public ArrayList<Company> getCreateCompanyRequests() {
    return new ArrayList<Company>();
  }

  public String resolveCreateCompanyRequest(int requestId) {
    return "";
  }

  public String deleteComment(String reason) {
    String result = "";

    return result;
  }
}