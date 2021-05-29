package work0529;

import java.util.Scanner;

public class FriendMain {

	public static void main(String[] args) {
		FriendHandler handler = new FriendHandler();
		for(;;) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("======메뉴======");
			System.out.println("1. 고등학교 친구 정보 입력");
			System.out.println("2. 대학친구 정보 입력");
			System.out.println("3. 정보 보기");
			System.out.println("4. 종료 하기");
			System.out.println("번호를 입력해주세요 > ");
			int choice = Integer.parseInt(scanner.nextLine());

			switch(choice) {
			case 1: 
				handler.inputInfo(1);
				break;
			case 2:
				handler.inputInfo(2);
			case 3: 
				handler.showInfo();
				break;
			case 4: 
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}
}
