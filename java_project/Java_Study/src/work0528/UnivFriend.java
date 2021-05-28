package work0528;

public class UnivFriend extends Friend {
	String major;
	public UnivFriend(String name, String phoneNumber, String address, String major) {
		super(name, phoneNumber, address);
		this.major = major;
	}
	@Override
	public void showData() {
		super.showData();
		System.out.println("전공: "+major);
	}
	@Override
	public void showBasicData() {
		System.out.println("이름 : "+name);
		System.out.println("전공 :" + major);
	}
	

}
