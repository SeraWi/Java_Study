package work0529_2;

import java.util.Scanner;

public class FriendInfoHandler {
	//저장 데이터(객체)를 배열로 저장하고 관리하는 기능을 가지는 클래스

	Friend[] friends;
	int numOfFriend; //배열의 입력 index 역할, 정보의 개수

	//생성자
	public FriendInfoHandler(int num) {// 배열의 사이즈 -> 배열 인스턴스 생성
		this.friends = new Friend[num];
		this.numOfFriend = 0;
	}
	//데이터의 입력처리
	//사용자로부터 친구의 정보를 입력 받아서 -> 인스턴스를 생성 -> 베열에 저장한다.

	public void addFriend(int choice) {//choice -> 1(고교),2(대학)
		Scanner s = new Scanner(System.in);

		System.out.println("이름을 입력해주세요 > ");
		String name = s.nextLine();
		System.out.println("전화번호를 입력해주세요 >");
		String phoneNumber= s.nextLine();
		System.out.println("주소를 입력해주세요 > ");
		String address = s.nextLine();

		if(choice ==1) {
			System.out.println("직업을 입력해주세요 >");
			String work = s.nextLine();
			addFriendInfo(new HighFriend(name, phoneNumber,address,work));
		}else {//대학친구
			System.out.println("전공을 입력해주세요 > ");
			String major = s.nextLine();
			addFriendInfo(new UnivFriend(name, phoneNumber,address,major));
		}
	}

	//배열에 저장하는 메서드
	public void addFriendInfo(Friend f) {
		friends[numOfFriend++] = f;
		System.out.println("정보가 저장되었습니다.");
	}
	public void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다.");
		System.out.println("=========================");
		if( numOfFriend > 0) {
			for(int i =0; i< numOfFriend; i++) {
				friends[i].showData();
				System.out.println("========================");
			}
		}else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println();
	}
	public void showAllBaiscData() {
		System.out.println("친구의 모든 기본 정보를 출력합니다.");
		System.out.println("============================");
		if(numOfFriend > 0) {
			for( int i= 0; i< numOfFriend; i++) {
				friends[i].showBasicInfo();
				System.out.println("=====================");
			}
		}else {
			 System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println();
	}


}



