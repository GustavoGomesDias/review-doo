package report;

import commentsComposite.Comments;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "report")
public class Report extends Observable {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int id;
  
  @Column(name = "reason")
  private String reason;
  
  @Column(name = "comment_id")
  @OneToMany
  private Comments origin;
  
  @Column(name = "sent")
  private boolean sent;
  
  public int getId() {
    return this.id;
  }
  
  public void setSent(boolean read) {
    this.sent = read;
  }
  
  public boolean getRead() {
    return this.sent;
  }
  
  public void setReason(String reason) {
    this.reason = reason;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public void setComments(Comments origin) {
    this.origin = origin;
  }
  
  public Comments getComments() {
    return this.origin;
  }
}
