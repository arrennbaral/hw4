public class Account {
  private final Object lock = new Object();
  // Must be private to be thread-safe!
  private int balance= 1000;

  public int getBal(){
    return balance;
  }

  public synchronized void withdraw(int bal){
    synchronized (lock) {
      balance= balance-bal;
    }
  }

  public synchronized void deposit(int bal){
    synchronized (lock) {
      balance= balance+bal;
    }
  }
}