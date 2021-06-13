package contactApp_ver01;

import java.util.Scanner;

public class AppMain {
	
	
	public static void main(String[] args) throws NameNotFindException {

		Scanner scanner = new Scanner(System.in);
		SmartPhone smart = new SmartPhone(); //스마트폰 생성
		while(true) {
			
			System.out.println("================================");
			System.out.println("연락처 관리프로그램");
			System.out.println("1. 연락처 입력");
			System.out.println("2. 연락처 검색");
			System.out.println("3. 연락처 수정");
			System.out.println("4. 연락처 삭제");
			System.out.println("5. 연락처 전체 리스트 보기");
			System.out.println("6. 파일 저장");
			System.out.println("7. 파일 로드");
			System.out.println("8. 종료");
			System.out.println("================================");

			int choice = Integer.parseInt(scanner.nextLine());
			// 메뉴 입력시 발생할 수 있는 예외에 대하여 예외 처리하기
			switch(choice) {
			case 1:
				smart.saveContact();
				break;
			case 2:
				smart.searchContact();
				break;
			case 3:
				smart.editContact();
				break;
			case 4:
				smart.deleteContact();
				break;
			case 5:
				smart.showList();
				break;
			}

		}
	}
}