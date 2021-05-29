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
	public void totalScore() {
		System.out.println(name+"의 총점은 "+ kor+eng+math+" 점 입니다.");
	}
	public void avgScore() {
		System.out.println(name+"의 평균은 "+(float)((kor+eng+math)/3)+" 점 입니다.");
	}
	public void showAllData() {
		System.out.println("이  름: "+ );
	}
}
