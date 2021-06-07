package work0607;

import java.util.Random;
import java.util.Scanner;

public class HighLowGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1~100사이의 숫자를 맞추면 됩니다.");
		
		Random random = new Random();
		int num = random.nextInt(100);
		System.out.println("랜덤 숫자: "+num);
		
		CountDownThread downThread = new CountDownThread();
		downThread.start();
		
		while(true) {
			System.out.println("숫자를 입력해주세요.");
			int userNum = Integer.parseInt(scanner.nextLine());
			if(userNum > num) {
				System.out.println("높은 숫자입니다.");
			}else if(userNum < num) {
				System.out.println("낮은 숫자입니다.");
			}else {
				System.out.println("정답입니다!!");
				System.exit(0);
			}
		}
	}
}

class CountDownThread extends Thread{

	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("10초가 지나 게임에 패했습니다.");
		System.exit(0);
	}
	
}