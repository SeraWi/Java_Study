package work0606_2;

import java.util.Scanner;

public class FriendHandler {
	
	//저장 데이터를 배열로 저장하고 관리하는 기능가지는 클래스
	
	Friend[] friends;
	int numOfFriend;
	
	FriendHandler(int num){//배열의 사이즈
		this.friends = new Friend[num];
		this.numOfFriend = 0;
	}
	
	void addFriend(int choice) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름을 입력해주세요.");
		String name = scanner.nextLine();
		System.out.println("전화번호를 입력해주세요.");
		String phoneNumber = scanner.nextLine();
		System.out.println("주소를 입력해주세요.");
		String address = scanner.nextLine();
		
		if(choice == 1) {//1. 고교 친구
			System.out.println("직업을 입력해주세요.");
			String work = scanner.nextLine();
			
			HighFriend hf = new HighFriend(name,phoneNumber,address,work);
			friends[numOfFriend] = hf;
			numOfFriend++;
			
		}else {//2.대학 친구
			System.out.println("전공을 입력해주세요.");
			String major = scanner.nextLine();
			
			UniFriend uf = new UniFriend(name, phoneNumber, address, major);
			friends[numOfFriend] = uf;
			numOfFriend++;
		}
		
	}
	
	void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다.");
		System.out.println("------------------------");
		
		if(numOfFriend >0) {
			for( int i= 0; i< numOfFriend; i++) {
				friends[i].showData();
				System.out.println("========================");
			}
				
		}else {
			System.out.println("입력된 정보가 없습니다.");
		}
	}
	
	
	void showBasicData() {
		System.out.println("친구의 기본 정보를 출력합니다.");
		System.out.println("------------------------");
		
		if(numOfFriend > 0) {
			for( int i= 0; i<numOfFriend; i++) {
				friends[i].showBasicInfo();
				System.out.println("=====================");
			}
		}else {
			System.out.println("입력된 정보가 없습니다. ");
		}
	}
}
