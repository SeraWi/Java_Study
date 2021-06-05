package work0605;

public class Thread05 {

	public static void main(String[] args) {
		Increment inc = new Increment();
		
		//쓰레드 생성
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);
		
		it1.start();
		it2.start();
		it3.start();
		
		
		try {
			it1.join(); // num=0->num=10
			it2.join(); // num= 10->num=20
			it3.join(); // num= 11-> num=30
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(inc.getNum());
	}

}
class Increment{
	int num= 0;
	
	public void increment() {
		num++;
	}
	
	public int getNum() {
		return num;
	}
}

class IncThread extends Thread{
	Increment inc;
	
	IncThread(Increment inc){
		this.inc = inc;
	}
	
	public void run() {
		for(int i = 0; i< 10; i++) {
			inc.increment();
		}
	}
}