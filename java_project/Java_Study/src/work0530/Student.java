package work0530;

public class Student {
	String name;
	int kor;
	int eng;
	int math;
	Student(String name, int kor,int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	int totalScore() {
		return kor+eng+math;
	}
	float avgScore() {
		return (kor+eng+math)/3.0f;
	}
	void showBasicInfo() {
		System.out.println("이   름: "+name);
		System.out.println("국어성적:"+kor);
		System.out.println("영어성적: "+eng);
		System.out.println("수학성적: "+math);
		System.out.println("국영수 총점: "+totalScore());
		System.out.println("국영수 평균: "+ avgScore());
	}
}
