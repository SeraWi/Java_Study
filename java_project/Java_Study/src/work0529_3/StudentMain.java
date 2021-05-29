package work0529_3;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		StudentHandler sh = new StudentHandler(10);
		for(;;) {
			Scanner scanner= new Scanner(System.in);
			System.out.println("-------메뉴---------");
			System.out.println("1. 학생 성적 입력");
			System.out.println("2. 학생 총점 조회하기");
			System.out.println("3. 학생 평균 조회하기");
			System.out.println("4. 학생 전체 정보 조회하기");
			System.out.println("5. 종료");
			System.out.println("메뉴를 선택하세요 > ");
			int choice = Integer.parseInt(scanner.nextLine());

			switch(choice) {
			case 1:
				sh.addStudent();
				break;
			case 2 :
				sh.totalScore();
				break;
			case 3:
				sh.avgScore();
				break;
			case 4:
				sh.showAllData();
				break;
			case 5:
				System.out.println("종료하겠습니다.");
				System.exit(0);
			}
		}
	}
}
