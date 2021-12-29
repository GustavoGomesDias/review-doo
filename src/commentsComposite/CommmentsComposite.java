package commentsComposite;

import company.Company;
import java.util.List;

public class CommmentsComposite extends CommentsAbstract {
  private List<CommentsAbstract> listOfReplies;
  private CommentsDAOImp dao = new CommentsDAOImp();
  
  public CommmentsComposite(String content, CommentsAbstract origin, Company originCompany) {
    this.content = content;
    this.temporaryCode = java.util.UUID.randomUUID().toString();
    this.companyOrigin = originCompany;
    if (origin != null) this.origin = origin;
  }
  
  public void populateListOfReplies() {
    
    this.listOfReplies = this.dao.getCommentsByOriginId(this.getId());
  }
  
  public List<CommentsAbstract> getListOfReplies() { return this.listOfReplies; }
  
  public CommentsAbstract getReplyByPos(int pos) {
    return this.listOfReplies.get(pos);
  }
}
