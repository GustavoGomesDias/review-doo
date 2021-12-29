package user;

/*
* private String name;
  private String email;
  private String password;
* */

import commentsComposite.Comments;
import company.Category;
import company.Company;
import java.util.List;

public interface UserInterface {
  public void deleteUser(int id);
  public void setName(String name);
  public String getName();
  public void setEmail(String email);
  public String getEmail();
  public void setPassword(String password);
  public String getPassword();
  public void setRole(String role);
  public String getRole();
  public String createComment(String email, String comment, int companyId);
  public String createReply(String content, Comments origin, int companyId);
  public List getAllCampanies();
  public Category getCategory(int categoryId);
  public List<Category> getAllCategory();
  public List<Company> getAllCompany();
  public String deleteCompany(int companyId);
}
