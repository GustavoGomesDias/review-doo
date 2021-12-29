package commentsComposite;

import DAO.GenericDAO;
import java.util.List;

public interface CommentsDAO extends GenericDAO<CommentsAbstract> {
  public List<CommentsAbstract> getCommentsByOriginId(int id);
}
