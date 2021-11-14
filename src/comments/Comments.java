package comments;

import java.util.ArrayList;
import java.util.Random;

public class Comments {
  private int id; // mock
  private String content;
  private String temporaryCode;
  private final ArrayList<Comments> arrReplies = new ArrayList<>();
  private boolean isReply = false; // Talvez não seja necessária com o banco
  private Comments origin;

  public Comments() {

  }

  public Comments updateComments(String content, String temporaryCode) {
    return this;
  }

  public void addReply(String content) {
    // pesquisa no se tem respota no banco e adicona ao array
    Comments comments = new Comments();
    comments.setReply(true);
    comments.setOriginComment(this);
    this.arrReplies.add(comments);
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

  public void setTemporaryCode() {
    this.temporaryCode = java.util.UUID.randomUUID().toString();
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

  public void setId() {
    this.id = new Random().nextInt();
  }
}
