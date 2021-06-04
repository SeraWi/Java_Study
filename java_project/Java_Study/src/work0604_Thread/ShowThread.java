package work0604_Thread;

public class ShowThread extends Thread{
	String tName;
	
	ShowThread(String tName){
		this.tName = tName;
	}

	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			System.out.println("안녕하세요~!"+tName+" 입니다.");
		}
		
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
