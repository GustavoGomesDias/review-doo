package company;

import comments.Comments;

import java.util.ArrayList;

public class Company {
  private int id;
  private String name;
  private int imageId;
  private ArrayList<Comments> comments = new ArrayList<>();

  public Company(int id, String name, int imageId) {
    this.id = id;
    this.name = name;
    this.imageId = imageId;
  }

  public void createCompany() {
    // db.save(this)
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getImageId() {
    return imageId;
  }

  public void setImageId(int imageId) {
    this.imageId = imageId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Comments> getComments() {
    return this.comments;
  }

  public void setComments(Comments comments) {
    // Buscar no banco e adicionar aqui
    this.comments.add(comments);
  }

  public Company getCompany(int companyId) {
    return this;
  }
}
