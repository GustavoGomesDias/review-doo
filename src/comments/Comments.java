package comments;

import DAO.GenericDAOImp;
import company.Company;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import report.*;

@Entity
@Table(name = "comments")
public class Comments {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int id;
  
  @Column(name = "content")
  private String content;
  @Column(name = "temporaryCode")
  private String temporaryCode;
 
  @Column(name = "origin_id", nullable = true)
  @OneToMany // ou ManyToOne
  private Comments origin;

  public Comments(String content) {
    this.setTemporaryCode("");
    this.setContent(content);
  }

  public void createComments() {
    // db.save(comments)
  }

  public Comments updateComments(String content, String temporaryCode) {
    return this;
  }

  public String addReply(String content, Comments origin) {
    // pesquisa no se tem respota no banco e adicona ao array
    Comments comments = new Comments(content);
    comments.setOriginComment(origin);
    
    return comments.getTemporaryCode();
  }

  public void deleteComments(String temporaryCode) {
    // Precisa do banco?
    if (temporaryCode.equals(this.temporaryCode)) {
      System.out.println("deletado!");
    }
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTemporaryCode() {
    return temporaryCode;
  }

  public void setTemporaryCode(String temporaryCode) {
    if (temporaryCode.equals("")) this.temporaryCode = java.util.UUID.randomUUID().toString();
    else this.temporaryCode = temporaryCode;
  }

  public Comments getOriginComment() {
    return this.origin;
  }

  public void setOriginComment(Comments orign) {
    this.origin = orign;
  }

  public int getId() {
    return id;
  }
  
  public void createReport(String reason, Comments origin) {
    Report report = new Report();
    report.setComments(origin);
    report.setReason(reason);
    GenericDAOImp<Report> generic = new GenericDAOImp<>();
    generic.salvar(report);
    report.notifyObs();
  }
}
