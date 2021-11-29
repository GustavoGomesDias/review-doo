package user;

/*
* private String name;
  private String email;
  private String password;
* */

import comments.Comments;
import company.Category;
import company.Company;
import java.util.List;

public interface UserInterface {
  void deleteUser(int id);
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
  public List getAllCampanies();
  public Category getCategory(int categoryId);
  public List<Category> getAllCategory();
  public List<Company> getAllCompany();
  public String deleteCompany(int companyId);
}
