package work0606_2;

public abstract class Friend {
	String name;
	String phoneNumber;
	String address;
	
	//생성자
	public Friend(String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public void showData() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+phoneNumber);
		System.out.println("주소: "+address);
		
	}
	
	public abstract void showBasicInfo();
	
}
