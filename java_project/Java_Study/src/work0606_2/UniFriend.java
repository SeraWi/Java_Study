package work0606_2;

public class UniFriend extends Friend{
	
	//대학친구는 전공
	
	String major;
	
	public UniFriend(String name, String phoneNumber, String address, String major) {
		super(name, phoneNumber, address);
		this.major = major;
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름:"+name);
		System.out.println("전공:"+major);
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("전공:"+major);
	}

}
