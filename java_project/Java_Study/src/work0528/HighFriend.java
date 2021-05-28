package work0528;

public class HighFriend extends Friend {
	String work;
	public HighFriend(String name, String phoneNumber, String address,String work) {
		super(name, phoneNumber, address);
		this.work = work;
	}
	@Override
	public void showData() {
		super.showData();
		System.out.println("직업: "+ work);
	}
	@Override
	public void showBasicData() {
		System.out.println("이름 :"+name);
		System.out.println("직업 :"+ work);
	}
}
