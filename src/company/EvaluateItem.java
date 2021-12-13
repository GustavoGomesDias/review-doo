package company;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "evaluateItems")
public class EvaluateItem {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "description")
  private String description;
  
  @OneToMany
  private Company company;
  
  public EvaluateItem(String name, String description) {
    this.name = name;
    this.description = description;
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
  
  public void setCompany(Company company) {
    this.company =  company;
  }
}
