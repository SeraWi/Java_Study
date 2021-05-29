package work0529;

public class UniFriend extends Friend{
	String major;
	UniFriend(String name, String phoneNum, String job,String major) {
		super(name, phoneNum, job);
		this.major = major;
	}
	@Override
	void showInfo() {
		super.showInfo();
		System.out.println("전   공: "+ major);
	}
	
	
}
