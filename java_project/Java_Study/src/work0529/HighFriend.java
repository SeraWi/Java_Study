package work0529;

public class HighFriend extends Friend {
	String uni;
	HighFriend(String name, String phoneNum, String job, String uni) {
		super(name, phoneNum, job);
		this.uni = uni;
	}
	@Override
	void showInfo() {
		super.showInfo();
		System.out.println("대   학: "+ uni);
	}
	

}
