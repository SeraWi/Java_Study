package work0604_Thread;

public class ShowThreadMain {

	public static void main(String[] args) {
		
		//쓰레드 인스턴스 생성
		ShowThread t1 = new ShowThread("쓰레드1");
		ShowThread t2 = new ShowThread("       쓰레드2");
		
		//쓰레드 실행
		t1.start();
		t2.start(); //run()메소드 실행된다.

	}

}
