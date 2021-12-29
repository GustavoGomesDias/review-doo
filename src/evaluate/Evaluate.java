package evaluateBuilder;

import company.EvaluateItem;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "evaluate")
public class Evaluate {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int id;

  @Column(name = "rate")
  private int rate;
  
  @Column(name = "description", nullable = true)
  private String evaluateDescription;
  
  @OneToMany
  private EvaluateItem eval;
  
  public Evaluate(int rate) {
    this.rate = rate;
  }
  
  public int getID() { return this.id; }
  
  public int getRate() { return this.rate; }
  
  public void setRate(int rate) {
    this.rate = rate;
  }
  
  public String getDescription() { return this.evaluateDescription; }
  
  public void setDescription(String description) {
    this.evaluateDescription = description;
  }
  
  public void setEvaluateItem(EvaluateItem eval) {
    this.eval = eval;
  }
}
