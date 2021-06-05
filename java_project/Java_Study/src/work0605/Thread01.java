package work0605;

public class Thread01 extends Thread{
	String tName;
	
	Thread01(String tName){
		this.tName = tName;
	}

	@Override
	public void run() {
		for(int i= 0; i<10; i++) {
			System.out.println("안녕하세요"+tName+"입니다");
		}
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
