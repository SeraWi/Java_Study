package work0606_2;

import java.util.Scanner;

public class FriendBook {
	public static void main(String[] args) {
		FriendHandler handler = new FriendHandler(5);

		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Friend Book==============");
			System.out.println("1. 고교 친구 입력");
			System.out.println("2. 대학 친구 입력");
			System.out.println("3. 친구 기본 정보 보기");
			System.out.println("4. 친구 기본 정보 보기");
			System.out.println("5. 종료");
			System.out.println("번호를 고르세요.");
			int choice = Integer.parseInt(scanner.nextLine());

			switch(choice){
			case  Menu.HIGH_FRI: case Menu.UNI_FRI:
				handler.addFriend(choice);
				break;
			case Menu.SHOW_ALL:
				handler.showBasicData();
				break;
			case Menu.SHOW_BASIC:
				handler.showAllData();
				break;
			case Menu.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
interface Menu{
	int HIGH_FRI= 1;
	int UNI_FRI= 2;
	int SHOW_ALL =3;
	int SHOW_BASIC =4;
	int EXIT= 5;
}