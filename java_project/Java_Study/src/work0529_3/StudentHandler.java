package work0529_3;

import java.util.Scanner;

public class StudentHandler {
	Student[] students;
	int numOfStudent;
	
	StudentHandler(int num){
		Student[] students = new Student[num];
		int numOfStudent = 0;
	}
	
	public void addStudent() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("학생 이름을 입력해주세요 > ");
		String name = scanner.nextLine();
		System.out.print("국어 성적을 입력해주세요 > ");
		int kor = Integer.parseInt(scanner.nextLine());
		System.out.print("영어 성적을 입력해주세요 > ");
		int eng = Integer.parseInt(scanner.nextLine());
		System.out.print("수학 성적을 입력해주세요 > ");
		int math = Integer.parseInt(scanner.nextLine());
		System.out.println("학생 성적이 저장되었습니다. > ");
		
		students[numOfStudent++] = new Student(name, kor, eng, math);
	}
	public void totalScore() {
		for( int i = 0; i< numOfStudent ; i++) {
			students[i].totalScore();
			System.out.println("===================");
		}
		System.out.println();
	}
	public void avgScore() {
		for( int i= 0;i < numOfStudent; i++) {
			students[i].avgScore();
			System.out.println("===================");
		}
		System.out.println();
	}
}
