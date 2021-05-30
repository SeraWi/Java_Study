package work0530;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		StudentHandler handler = new StudentHandler(10);
		while(true) {
			Scanner scanner= new Scanner(System.in);
			System.out.println("-------메뉴-------");
			System.out.println("1. 이과 학생 성적 입력");
			System.out.println("2. 문과 학생 성적 입력");
			System.out.println("3. 예체능 학생 성적 입력");
			System.out.println("4. 학생 국영수 점수 보기");
			System.out.println("5. 학생 전체 성적 보기");
			System.out.println("6. 종료");
			System.out.print("번호를 입력하세요. > ");
			int choice = Integer.parseInt(scanner.nextLine());

			switch(choice) {
			case 1:case 2: case 3:
				handler.addStudent(choice);
				break;
			case 4:
				handler.showBasicInfo();
				break;
			case 5:
				handler.showAllInfo();
				break;
			case 6:
				System.out.println("종료 합니다.");
				System.exit(0);
			}

		}
	}
}