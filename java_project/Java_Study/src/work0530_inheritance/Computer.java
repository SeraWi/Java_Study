package work0530_inheritance;

public class Computer {
	String owner;
	public Computer(String name) {
		owner = name;
	}
	public void calculate() {
		System.out.println("요청 내용을 계산합니다.");
	}
}
