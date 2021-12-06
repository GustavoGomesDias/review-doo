package report;

import java.util.*;

public abstract class Observable {
  List<Observer> observer = new ArrayList<>();
  
  public void add(Observer obs) {
    this.observer.add(obs);
  }
  
  public void delete(Observer obs) {
    this.delete(obs);
  }
  
  public void notifyObs() {
    for (Observer obs: this.observer) {
      obs.updateObserver(this);
    }
  }
}
