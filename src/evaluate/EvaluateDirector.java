package evaluate;

import company.EvaluateItem;
import user.User;

public class EvaluateDirector {
  public Evaluate build(EvaluateItem item, User user, String description, int rate) {
    EvaluateBuilder builder = new EvaluateBuilder();
    builder.checkBannedUser(user);
    builder.addEvaluate(rate);
    if (description != null) builder.addEvaluateDescriptionIfExists(description);
    return builder.saveEvaluate(item);
  }
}
