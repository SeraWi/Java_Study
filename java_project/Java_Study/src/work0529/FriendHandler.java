package work0529;

import java.util.Scanner;

public class FriendHandler {
	Friend[] friends;
	int numOfFriend;
	
	FriendHandler(){
		friends = new Friend[10];
		numOfFriend = 0;
	}
	
	void inputInfo (int choice) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름을 입력하세요 >");
		String name = scanner.nextLine();
		System.out.print("전화번호를 입력하세요 >");
		String phoneNum = scanner.nextLine();
		System.out.print("직업을 입력하세요 >");
		String job=  scanner.nextLine();
		
		if(choice == 1) {
			System.out.print("대학을 입력하세요 >");
			String uni = scanner.nextLine();
			friends[numOfFriend] = new HighFriend(name, phoneNum,job,uni);
			numOfFriend++;
		}else {
			System.out.print("전공을 입력하세요 >");
			String major =scanner.nextLine();
			friends[numOfFriend] = new UniFriend(name, phoneNum,job, major);
			numOfFriend++;
		}
	}
	
	void showInfo() {
		for(int i = 0 ; i< numOfFriend; i++) {
			friends[i].showInfo();
			System.out.println("===================");
		}
	}
}
