package work0605;

public class Thread03 {
	public static void main(String[] args) {
		AdderThread at1 = new AdderThread(1,5);
		AdderThread at2 = new AdderThread(6,10);
		
		//Runnable target
		
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); //mainThread가 t1의 작업이 끝날때까지 기다린다.
			t2.join(); //mainThread가 t2의 작업이 끝날 때까지 기다린다.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1~100까지의 숫자합:"+ (at1.getNum()+at2.getNum()));
	}
}


class Sum{
	int num;
	
	public void addNum(int n) {
		num+=n;
	}
	public int getNum() {
		return num;
	}
}

class AdderThread extends Sum implements Runnable{
	int startNum;
	int endNum;
	
	AdderThread(int n1, int n2){
		this.startNum = n1;
		this.endNum = n2;		
	}

	@Override
	public void run() {
		for(int i= startNum; i<= endNum; i++) {
			addNum(i);
		}
		
	}
}