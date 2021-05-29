package work0529_3;

public class Student {
	// 학생 성적, 총합, 평균, 정보보기
	String name;
	int kor;
	int eng;
	int math;
	
	Student(String name, int kor, int eng, int math){
		this.name = name;
		this.kor =kor;
		this.eng = eng;
		this.math = math;
	}
	public int totalScore() {
		return kor + eng + math ;
	}
	public float avgScore() {
		return (float)((kor+eng+math)/3);
	}
	public void showAllData() {
		System.out.println("이  름: "+ name);
		System.out.println("총  점: "+ totalScore());
		System.out.println("평  균: "+ avgScore());
	}
}
