package company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "company")
public class Company {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int id;
  
  private String name;
  private int imageId;
  private boolean isRequest;

  public Company(String name, int imageId, boolean isRequest) {
    this.name = name;
    this.imageId = imageId;
    this.isRequest = isRequest;
  }

  public void createCompany() {
    // db.save(this)
  }
  
  public boolean getIsRequest() { return this.isRequest; }
  public void setIsRequest(boolean isRequest) { this.isRequest = isRequest; }

  public int getId() {
    return id;
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
}
