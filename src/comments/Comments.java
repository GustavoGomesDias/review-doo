package comments;

import java.util.ArrayList;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comments")
public class Comments {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private int id;
  
  private String content;
  private String temporaryCode;
  private final ArrayList<Comments> arrReplies = new ArrayList<>();
  private boolean isReply = false; // Talvez não seja necessária com o banco
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

  public String addReply(String content) {
    // pesquisa no se tem respota no banco e adicona ao array
    Comments comments = new Comments(content);
    comments.setReply(true);
    comments.setOriginComment(this);
    this.arrReplies.add(comments);
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
 
  public ArrayList<Comments> getReplies() {
    return this.arrReplies;
  }

  public boolean isReply() {
    return isReply;
  }

  public void setReply(boolean reply) {
    this.isReply = reply;
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
}
