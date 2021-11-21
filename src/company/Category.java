package company;

import java.util.ArrayList;
import java.util.Random;

public class Category {
  private int id;
  private String name;
  private String description;
  private ArrayList<Company> companies = new ArrayList<>();

  public Category(String name, String description) {
    this.id = new Random().nextInt();
    this.name = name;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
