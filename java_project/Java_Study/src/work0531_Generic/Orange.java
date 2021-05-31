package work0531_Generic;

public class Orange {
	
	int sugarContent;// 당분함량
	
	public Orange(int sugar) {
		sugarContent = sugar;
	}
	public void showSugarContent() {
		System.out.println("당도"+sugarContent);
	}
}
