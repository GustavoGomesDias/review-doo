package user;

import DAO.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImp extends GenericDAOImp<UserInterface> implements UserDAO {
  public UserInterface login(String email, String password){
    Session session = HibernateUtil.getSession().openSession();
    Transaction transaction = session.beginTransaction();
    UserInterface user;
    user = (UserInterface) session.createQuery("'from users where login = '" + email + "' and senha = '" + password + "'");
    transaction.commit();
    session.flush();
    session.close();
    if (user == null) return null;
    return user;
  }
}
