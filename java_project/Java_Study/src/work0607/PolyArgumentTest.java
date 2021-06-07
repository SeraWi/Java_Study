package work0607;

public class PolyArgumentTest {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.summary();
	}
}
class Product{
	int price;
	int bonusPoint;

	Product(int price){
		this.price = price;
		this. bonusPoint = (int)(price/10.0);
	}

	Product(){
		price = 0;
		bonusPoint = 0;
	}
}

class Tv extends Product{
	Tv(){
		super(100); //price : 100
	}

	@Override
	public String toString() {
		return "Tv ";
	}
}

class Computer extends Product {
	Computer(){
		super(200);
	}
	@Override
	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio(){
		super(50);
	}

	@Override
	public String toString() {
		return "Audio ";
	}
}
class Buyer{
	int money = 1000;
	int bonusPoint = 0;
	Product [] item = new Product[10];
	int numOfProduct = 0;

	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}

		money -=p.price;
		bonusPoint += p.bonusPoint;
		item[numOfProduct++] = p; //제품을 Product[] item에 저장한다.
		System.out.println(p+"을 구입하셨습니다.");
	}
	void summary() {
		int sum = 0;
		String itemList ="";

		for(int i= 0; i< item.length; i++) {
			if(item[i] == null) {
				break;
			}
			sum += item[i].price;
			itemList += item[i]+",";
		}
		System.out.println("구입하신 물품의 총금액은 "+sum+"만원입니다.");
		System.out.println("구입하신 제품은"+itemList +"입니다.");
	}

}