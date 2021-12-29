package user;

import commentsComposite.Comments;
import company.Category;
import company.Company;
import DAO.*;
import report.*;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
// import org.hibernate.annotations.*;

@Entity
@Table(name = "users")
public class Admin implements UserInterface, Observer {
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
  private String role = "admin";

  public Admin(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public int getId() { return this.id; }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
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
  
  public void deleteComment(int id) {
    GenericDAOImp<Comments> generic = new GenericDAOImp<>();
    Comments comments = null;
    comments = (Comments) generic.listar(comments.getClass(), id);
    generic.delete(comments);
  }

  public void acceptCreateCompanyRequest(Company company) {
    GenericDAOImp<Company> generic = new GenericDAOImp<>();
    generic.salvar(company);
  }

  public List getAllCampanies() {
    GenericDAOImp<Company> generic = new GenericDAOImp<>();
    Company company = new Company();
    return generic.listarTodos(company.getClass());
  }

  public Category createCategory(String name, String description) {
    Category category = new Category(name, description);
    GenericDAOImp<Category> generic = new GenericDAOImp<>();
    generic.salvar(category);
    return category;
  }

  public Category getCategory(int categoryId) {
    GenericDAOImp<Category> generic = new GenericDAOImp<>();
    return (Category) generic.listar(Category.class, id);
  }

  public List<Category> getAllCategory() {
    GenericDAOImp<Category> generic = new GenericDAOImp<>();
    return generic.listarTodos(Category.class);
  }

  public String deleteCategory(int categoryId) {
    GenericDAOImp<Category> generic = new GenericDAOImp<>();
    Category category = (Category) generic.listar(Category.class, categoryId);
    generic.delete(category);
    return "Deletado com sucesso!";
  }

  public Company getCompany(int companyId) {
    GenericDAOImp<Company> generic = new GenericDAOImp<>();
    return (Company) generic.listar(Company.class,companyId);
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

  public List<Company> getCreateCompanyRequests() {
    return new ArrayList<Company>();
  }

  public String resolveCreateCompanyRequest(int requestId) {
    return "";
  }

  public String deleteComment(String reason) {
    String result = "";

    return result;
  }
  
  public void deleteUser(int id) {
    GenericDAOImp<UserInterface> generic = new GenericDAOImp();
    UserInterface user = generic.listar(UserInterface.class, id);
    generic.delete(user);
  }

  public void notifyReport(Report report) {
    GenericDAOImp<Report> generic = new GenericDAOImp();
    generic.listar(Report.class, report.getId());
    // sendEmail()
    report.setSent(true);
    generic.atualizar(report);
  }
  
  public void notifyCompanyRequest(Company company) {
    GenericDAOImp<Company> generic = new GenericDAOImp();
    generic.listar(Company.class, company.getId());
    // sendEmail()
    generic.atualizar(company);
  }
  
  @Override
  public void updateObserver(Observable o) {
    this.notifyReport((Report) o);
  }
  
}