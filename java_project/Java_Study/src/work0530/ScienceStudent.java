package work0530;

public class ScienceStudent extends Student {
	int sci;
	ScienceStudent(String name, int kor, int eng, int math, int sci) {
		super(name, kor, eng, math);
		this.sci = sci;
	}
	@Override
	int totalScore() {
		return super.totalScore()+sci;
	}
	@Override
	float avgScore() {
		return totalScore()/4.0f;
	}
	@Override
	void showBasicInfo() {
		super.showBasicInfo();
	}
	void showAllInfo() {
		showBasicInfo();
		System.out.println("과학 성적: "+ sci);
		System.out.println("국영수과총점"+ this.totalScore());
		System.out.println("국영수과 평균: "+this.avgScore());
	}

}
