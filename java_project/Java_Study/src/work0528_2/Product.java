package work0528_2;

public class Product {
	final int price;
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		this.bonusPoint = (int) (price / 10.0);
	}
}
