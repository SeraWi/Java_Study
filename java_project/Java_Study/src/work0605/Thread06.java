package work0605;

public class Thread06 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx();
		new Thread(r).start();
		new Thread(r).start();
	}
}
class Account{
	private int balance = 1000;
	
	public int getBalance() {
		return this.balance;
	}
	public synchronized void withdraw(int money) { // 메서드 동기화 하지 않으면, balnce가 마이너스값 나온다.
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance-= money;
		}
	}
}

class RunnableEx implements Runnable{

	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			//100,200,300 중의 한값을 임의로 선택해서 출금
			
			int money = (int)(Math.random()*3+1)*100;
			acc.withdraw(money);
			System.out.println("balance: "+ acc.getBalance());
		}
		
	}
	
}
