package work0529_3;

import java.util.Scanner;

public class StudentHandler {
	Student[] students;
	int numOfStudent;
	
	StudentHandler(int num){
		this. students = new Student[num];
		this.numOfStudent  = 0;
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
		
		students[numOfStudent++] = new Student(name,kor,eng,math);
		System.out.println("학생 성적이 저장되었습니다. > ");
	}
	public void totalScore() {
		for( int i = 0; i< numOfStudent ; i++) {
			System.out.println(students[i].name+"의 총점은"+ students[i].totalScore() +"입니다.");
			System.out.println("===================");
		}
		System.out.println();
	}
	public void avgScore() {
		for( int i= 0;i < numOfStudent; i++) {
			System.out.println(students[i].name+"의 평균은"+ students[i].avgScore() +"입니다.");
			System.out.println("===================");
		}
		System.out.println();
	}
	public void showAllData() {
		for( int i = 0; i< numOfStudent; i++) {
			students[i].showAllData();
			System.out.println("=====================");
		}
		
	}
}
