package user;

import DAO.GenericDAOImp;
import company.Company;
import report.*;

public class NotifyAdmin implements Observer {

  public void notifyCompanyRequest(Company company) {
    GenericDAOImp<Company> generic = new GenericDAOImp();
    generic.listar(Company.class, company.getId());
    // sendEmail()
  }
  
  @Override
  public void updateObserver(Observable o) {
    
    this.notifyCompanyRequest((Company) o);
  }
  
}
