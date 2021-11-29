package company;
import DAO.GenericDAO;
import java.util.List;

public interface CompanyDAO extends GenericDAO<Company> {
  public List<Company> getAllRequests();
  public void acceptRequest(Company company);
  public void recuseRequest(Company company);
}
