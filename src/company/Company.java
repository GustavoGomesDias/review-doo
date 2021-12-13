package company;

import DAO.GenericDAOImp;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import report.*;

@Entity
@Table(name = "company")
public class Company extends Observable {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int id;

  @Column(name = "name")
  private String name;
  @Column(name = "logo")
  private String imageUrl;
  @Column(name = "request")
  private boolean isRequest;
  @Column(name = "category_id")
  // ou @ManyToOne, mas cada empresapode ter só uma categoria (ou seja, deve-se pegar a categoria "main" da empresa)
  @OneToMany
  private Category category;
  
  private List<EvaluateItem> items;

  public Company(String name, String imagerl, boolean isRequest) {
    this.name = name;
    this.imageUrl = imagerl;
    this.isRequest = isRequest;
  }

  public Company() {

  }

  public int getId() {
    return this.id;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Category getCategory() {
    return this.category;
  }

  public void createCompany() {
    // db.save(this)
  }

  public boolean getIsRequest() {
    return this.isRequest;
  }

  public void setIsRequest(boolean isRequest) {
    this.isRequest = isRequest;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void createEvaluateItem(String name, String description) {
    GenericDAOImp<EvaluateItem> generic = new GenericDAOImp();
    EvaluateItem eval = new EvaluateItem(name, description);
    eval.setCompany(this);
    generic.salvar(eval);
  }
  
  public void getAllEvaluateItems() {
    CompanyDAOImp dao = new CompanyDAOImp();
    this.items = dao.getAllEvaluateItems(this);
  }
}
