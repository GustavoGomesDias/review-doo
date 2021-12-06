package user;

import DAO.*;
import comments.*;
import company.Category;
import company.Company;
import java.util.List;

import java.util.Random;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User implements UserInterface{
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int id;
  
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;
  @Column(name = "role")
  private String role = "user";
  
  public User(String name, String email, String password) {
    this.setName(name);
    this.setEmail(email);
    this.setPassword(password);
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


@Override
  public String createComment(String email, String comment, int companyId) {
    Comments comments = new Comments(comment);
    GenericDAOImp<Comments> generic = new GenericDAOImp<>();
    generic.salvar(comments);
    return comments.getTemporaryCode();
  }

  @Override
  public String createReply(String content, Comments origin) {
    return origin.addReply(content);
  }
  
  public String createCompanyRequest(String name, String imageUrl, int categoryId) {
    GenericDAOImp<Company> generic = new GenericDAOImp();
    GenericDAOImp<Category> genericCategory = new GenericDAOImp();
    Category category = genericCategory.listar(Category.class, categoryId);
    Company company = new Company();
    company.setImageUrl(imageUrl);
    company.setName(name);
    company.setIsRequest(true);
    company.setCategory(category);
    generic.salvar(company);
    company.notifyObs();
    return "Pedido criado com sucesso!";
  }

  public String deleteComment(int commentId, String temporaryCode) {
    GenericDAOImp<Comments> generic = new GenericDAOImp();
    Comments comments = generic.listar(Comments.class, commentId);
    
    if (commentId == comments.getId() && temporaryCode.equals(comments.getTemporaryCode())) {
      generic.delete(comments);
      return "Comentário deletado com sucesso!";
    }
    return "Comentário não encontrado!";
  }

  public Company evaluate(int value, String featEvaluated) {
    return new Company();
  }

  @Override
  public void deleteUser(int id) {
    GenericDAOImp<UserInterface> generic = new GenericDAOImp();
    generic.delete(this);
  }
  
  public List getAllCampanies() {
    GenericDAOImp<Company> generic = new GenericDAOImp<>();
    Company company = new Company();
    return generic.listarTodos(company.getClass());
  }
  
  public Category getCategory(int categoryId) {
    GenericDAOImp<Category> generic = new GenericDAOImp<>();
    return (Category) generic.listar(Category.class, id);
  }

  public List<Category> getAllCategory() {
    GenericDAOImp<Category> generic = new GenericDAOImp<>();
    return generic.listarTodos(Category.class);
  }
  
  public List<Company> getAllCompany() {
    GenericDAOImp<Company> generic = new GenericDAOImp<>();
    return generic.listarTodos(Company.class);
  }

  public String deleteCompany(int companyId) {
    GenericDAOImp<Company> generic = new GenericDAOImp<>();
    Company company = (Company) generic.listar(Company.class, companyId);
    generic.delete(company);
    return "Deletado com sucesso!";
  }
}
