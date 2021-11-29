package user;

import DAO.GenericDAO;

public interface UserDAO extends GenericDAO<UserInterface> {
  public UserInterface login(String email, String password);
}
