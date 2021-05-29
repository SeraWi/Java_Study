package work0529;

public class Friend {
	String name;
	String phoneNum;
	String job;
	
	Friend(String name, String phoneNum, String job){
		this.name = name;
		this.phoneNum = phoneNum;
		this.job = job;
	}
	
	public String toString() {
		return "이름은 "+ name +"이고, 전화번호는 "+phoneNum+" 입니다.";
	}
	void showInfo() {
		System.out.println("이   름: "+ name);
		System.out.println("전화번호: "+ phoneNum);
		System.out.println("직   업: "+ job);
	}
	
}
