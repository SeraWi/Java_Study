package work0530;

import java.util.Scanner;

public class StudentHandler {
	Student[] students;
	int numOfStudent;

	StudentHandler(int num){
		students = new Student[num];
		int numOfStudent = 0;
	}

	void addStudent(int choice) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("학생 정보를 입력합니다.");
		System.out.print("학생 이름을 입력해주세요 > ");
		String name = scanner.nextLine();
		System.out.print("국어 성적을 입력해주세요 >");
		int kor = Integer.parseInt(scanner.nextLine());
		System.out.println("영어 성적을 입력해주세요 >");
		int eng = Integer.parseInt(scanner.nextLine());
		System.out.println("수학 성적을 입력해주세요 >");
		int math = Integer.parseInt(scanner.nextLine());

		if( choice == 1) {
			System.out.print("과학성적을 입력해주세요 > ");
			int sci = Integer.parseInt(scanner.nextLine());
			addStudentarray(new ScienceStudent(name, kor, eng, math,sci));
		}else if( choice ==2 ) {
			System.out.println("제2외국어 성적을 입력해주세요 > ");
			int sec = Integer.parseInt(scanner.nextLine());
			addStudentarray(new LiberalStudent(name, kor, eng, math, sec));
		}else {
			System.out.println("음악 성적을 입력해주세요 >");
			int music = Integer.parseInt(scanner.nextLine());
			addStudentarray(new MusicStudent(name, kor, eng, math, music));
		}

	}
	public void addStudentarray(Student s) {
		students[numOfStudent++] = s;
	}
	public void showBasicInfo() {
		for(int i = 0; i< numOfStudent ; i++) {
			students[i].showBasicInfo();
			System.out.println("=========================");
		}
	}
	public void showAllInfo() {
		for(int i= 0; i<numOfStudent ; i++) {
			students[i].showAllInfo();
			System.out.println("=========================");
		}
	}
}
