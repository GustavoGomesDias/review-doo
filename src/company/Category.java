package company;

import java.util.ArrayList;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "category")
public class Category {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int id;
  
  private String name;
  private String description;

  public Category(String name, String description) {
    this.id = new Random().nextInt();
    this.name = name;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ArrayList<Company> getCompanies() {
    return this.companies;
  }

  public void setCompanies(Company company) {
    this.companies.add(company);
  }

  public Category updateCategory(int categoryId) {
    return this;
  }

  public void deleteCategory(int categoryId) {}
}
