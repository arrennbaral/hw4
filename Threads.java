public class Threads implements Runnable{

    Account account = new Account();

    public static void main(String[] args) {
        Threads ts = new Threads();
        Thread p1 = new Thread(ts, "person 1");
        Thread p2 = new Thread(ts, "person 2");

        p1.start();
        p2.start();
      
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            withDraw(100);
            if (account.getBal() < 0) {
                System.out.println("account is overdrawn!");
            }
            deposit(200);
        }
    }


    private synchronized void withDraw(int bal){
        if (account.getBal()>=bal) {
            System.out.println(Thread.currentThread().getName()+" "+ "trying to withdraw");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            account.withdraw(bal);
            System.out.println(Thread.currentThread().getName()+" "+ "Successful Withdrawal");
        }else{        
            System.out.println(Thread.currentThread().getName()+ " "+" is low on balance");
        }
    }

    private synchronized void deposit(int bal){
        if (bal>0) {
            System.out.println(Thread.currentThread().getName()+" "+ "trying to deposit");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            account.deposit(bal);
            System.out.println(Thread.currentThread().getName()+" "+ "Successful Deposit");
        }else{        
            System.out.println(Thread.currentThread().getName()+ " "+"Unsuccessful Deposit");
        }
    }
}