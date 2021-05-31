package work0531_Interface;

public class PersonalNumInfo {
	String name;
	String number;
	//생성자
	PersonalNumInfo(String name, String number){
		this.name = name;
		this.number= number;
	}
	String getName() {
		return name;
	}
	String getNumber() {
		return number;
	}
}
