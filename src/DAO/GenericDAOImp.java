package DAO;

import java.util.List;
import org.hibernate.Criteria;
// import javax.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDAOImp<T> implements GenericDAO<T> {
  protected static Session session;
  protected Transaction transaction;

  @Override
  public List<T> listarTodos(Class cl) {
    GenericDAOImp.session = HibernateUtil.getSession().openSession();
    this.transaction = session.beginTransaction();
    List t;
    t = null;
    Criteria selectAll = session.createCriteria(cl);
    this.transaction.commit();
    t = selectAll.list();
    session.flush();
    session.close();
    return t;
  }

  @Override
  public T listar(Class cl, int id) {
    GenericDAOImp.session = HibernateUtil.getSession().openSession();
    this.transaction = session.beginTransaction();
    T findById = (T) session.get(cl, id);
    this.transaction.commit();
    session.flush();
    session.close();
    return findById;
  }

  @Override
  public void atualizar(T t) {
    GenericDAOImp.session = HibernateUtil.getSession().openSession();
    this.transaction = session.beginTransaction();
    this.transaction.commit();
    session.flush();
    session.close();
  }

  @Override
  public void delete(T t) {
    GenericDAOImp.session = HibernateUtil.getSession().openSession();
    this.transaction = session.beginTransaction();
    session.delete(t);
    this.transaction.commit();
    session.flush();
    session.close();
  }

  @Override
  public void salvar(T t) {
    GenericDAOImp.session = HibernateUtil.getSession().openSession();
    this.transaction = session.beginTransaction();
    session.save(t);
    this.transaction.commit();
    session.flush();
    session.close();
  }
}
