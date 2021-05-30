package work0530_inheritance;

public class NotebookComp extends Computer{
	int battary;
	
	public NotebookComp(String name, int initChag) {
		super(name);
		this.battary = initChag;
	}
	public void charging() {
		battary += 5;
	}
	public void movingCal() {
		if(battary < 1) {
			System.out.println("충전이 필요합니다.");
			return;
		}
		System.out.println("이동하면서");
		calculate();
		battary -=1;
	}
}
