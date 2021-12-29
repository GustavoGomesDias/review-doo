package commentsComposite;

import DAO.GenericDAOImp;
import company.Company;

public class Comments extends CommentsAbstract {
  
  public Comments(String content, CommentsAbstract origin, Company originCompany) {
    this.content = content;
    this.temporaryCode = java.util.UUID.randomUUID().toString();
    this.companyOrigin = originCompany;
    if (origin != null) this.origin = origin;
  }
  
  @Override
  public CommentsAbstract getThisComment() { return this; }
}
