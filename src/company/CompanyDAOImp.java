package company;

import DAO.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompanyDAOImp extends GenericDAOImp<Company> implements CompanyDAO{

  @Override
  public void acceptRequest(Company company) {
    Session session = HibernateUtil.getSession().openSession();
    Transaction transaction = session.beginTransaction();
    company.setIsRequest(true);
    session.update(company);
    transaction.commit();
    session.flush();
    session.close();
  }

  @Override
  public void recuseRequest(Company company) {
    if (company.getIsRequest()) {
      Session session = HibernateUtil.getSession().openSession();
      Transaction transaction = session.beginTransaction();
      company.setIsRequest(true);
      session.delete(company);
      transaction.commit();
      session.flush();
      session.close();
    }
  }

  @Override
  public List<Company> getAllRequests() {
    Session session = HibernateUtil.getSession().openSession();
    Transaction transaction = session.beginTransaction();
    List<Company> companies = session.createQuery("'from users where isRequired = '" + true + "'").list();
    transaction.commit();
    session.flush();
    session.close();
    return companies;
  }
  
}
