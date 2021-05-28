package work0528;

public class Friend {
	String name;
	String phoneNumber;
	String address;
	
	public Friend(String name, String phoneNumber, String address ) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public void showData() {
		System.out.println("이름 :"+name);
		System.out.println("전화번호: "+ phoneNumber);
		System.out.println("주소: "+ address);
	}
	public void showBasicData() {
		
	}
}
