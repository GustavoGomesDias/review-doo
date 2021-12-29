package evaluateBuilder;

import DAO.GenericDAOImp;
import company.EvaluateItem;
import user.User;

public class EvaluateBuilder {

  private Evaluate evaluate;
  private boolean isBanned;
  
  public void checkBannedUser(User user) {
    this.isBanned = user.getIsBanned();
  }
  
  public void addEvaluate(int rate) {
    if (!this.isBanned) {
      Evaluate eval = new Evaluate(rate);
      this.evaluate = eval;
    } else {
      System.out.println("Usuário banido!");
    }
  }
  
  public void addEvaluateDescriptionIfExists(String description) {
    this.evaluate.setDescription(description);
  }
  
  public Evaluate saveEvaluate(EvaluateItem item) {
    GenericDAOImp<Evaluate> generic = new GenericDAOImp();
    this.evaluate.setEvaluateItem(item);
    generic.salvar(this.evaluate);
    return this.evaluate;
  }
}
