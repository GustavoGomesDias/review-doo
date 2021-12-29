package commentsComposite;

import DAO.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentsDAOImp extends GenericDAOImp<CommentsAbstract> implements CommentsDAO {

  @Override
  public List<CommentsAbstract> getCommentsByOriginId(int id) {
   Session session = HibernateUtil.getSession().openSession();
    Transaction transaction = session.beginTransaction();
    List<CommentsAbstract> listOfComments;
    listOfComments = (List<CommentsAbstract>) session.createQuery("'from users where origin_id = '" + id);
    transaction.commit();
    session.flush();
    session.close();
    if (listOfComments.isEmpty()) return null;
    return listOfComments;
  }
}
