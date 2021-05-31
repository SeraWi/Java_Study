package work0531_Generic;

public class GenericBaseFruitBox {

	public static void main(String[] args) {
		FruitBox<Orange> orBox = new FruitBox<Orange>(new Orange(10));
		//orBox.store(new Orange(10));
		Orange org = orBox.pullOut();
		org.showSugarContent();//당도10
		
		FruitBox<Apple> apBox = new FruitBox<Apple>(new Apple(20));
		//apBox.store(new Apple(20));
		Apple app = apBox.pullOut();
		app.showAppleWeight();//무게20
		
	}

}
