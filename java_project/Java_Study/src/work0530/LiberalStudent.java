package work0530;

public class LiberalStudent extends Student{
	int sec;//제2외국어 점수
	LiberalStudent(String name, int kor, int eng, int math, int sec) {
		super(name, kor, eng, math);
		this.sec = sec;
	}
	@Override
	int totalScore() {
		return super.totalScore()+sec;
	}
	@Override
	float avgScore() {
		return totalScore()/4.0f;
	}
	@Override
	void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("제 2외국어 성적: " + sec);
		System.out.println("국영수외 총점: "+this.totalScore());
		System.out.println("국영수외 평균:"+ this.avgScore());
	}

}
