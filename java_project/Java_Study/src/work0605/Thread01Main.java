package work0605;

public class Thread01Main {
	public static void main(String[] args) {
		Thread01 t1 = new Thread01("쓰레드1");
		Thread01  t2 = new Thread01("     쓰레드2");
		
		//쓰레드 실행
		t1.start();
		t2.start();
		
	}
}
