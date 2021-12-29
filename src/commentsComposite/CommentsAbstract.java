package commentsComposite;

import DAO.GenericDAOImp;
import company.Company;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import report.*;

@Entity
@Table(name = "comments")
public abstract class CommentsAbstract {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int id;
  
  @Column(name = "content")
  protected String content;
  @Column(name = "temporaryCode")
  protected String temporaryCode;
 
  @Column(name = "origin_id", nullable = true)
  @OneToMany // ou ManyToOne
  protected CommentsAbstract origin = null;
  
  @Column(name = "company_id", nullable = false)
  @OneToMany
  protected Company companyOrigin;
  
  public boolean isOrigin() {
    return (this.origin == null);
  }
  
  public String getContent() { return this.content; }
  public int getId() { return this.id; }
  public String getTemporaryCode() { return this.temporaryCode; }
  public CommentsAbstract getOrigin() { return this.origin; }
  public Company getCompany() { return this.companyOrigin; }
  public CommentsAbstract getThisComment() {return null; }
}
