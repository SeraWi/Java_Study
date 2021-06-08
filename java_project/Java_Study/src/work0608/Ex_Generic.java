package work0608;

public class Ex_Generic {
	public static void main(String[] args) {
		FruitBox<Orange> orBox = new FruitBox<Orange>();
		orBox.store(new Orange(10)); //당도 10인 오렌지객체 저장
		Orange org = orBox.pullOut(); // item 리턴
		org.showSugarContent();
		
		FruitBox<Apple> apBox = new FruitBox<Apple>();
		Apple ap = new Apple(300);
		apBox.store(ap);
		ap.showAppleWeight();
	}
}
class FruitBox<T>{
	T item;
	
	public void store(T item) { // 과일 저장
		this.item = item;
	}
	public T pullOut() {// 과일 꺼내오기
		return item;
	}
}

class Orange{
	int sugarContent; //당분 함량
	
	//생성자
	public Orange(int sugarContent) {
		this.sugarContent = sugarContent;
	}
	
	public void showSugarContent() {
		System.out.println("당도:"+sugarContent);
	}
}
class Apple{
	int weight; //사과의 무게
	
	//생성자
	public Apple(int weight) {
		this.weight = weight;
	}
	
	public void showAppleWeight() {
		System.out.println("무게: "+weight);
	}
}