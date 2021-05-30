package work0530;

public class MusicStudent extends Student{
	int music;
	MusicStudent(String name, int kor, int eng, int math, int music) {
		super(name, kor, eng, math);
		this.music = music;
	}
	
	@Override
	int totalScore() {
		return super.totalScore()+music;
	}
	@Override
	float avgScore() {
		return totalScore()/ 4.0f;
	}
	@Override
	void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("음악 성적: "+music);
		System.out.println("국영수음 총점: "+this.totalScore());
		System.out.println("국영수음 평균: "+this.avgScore());
	}
}