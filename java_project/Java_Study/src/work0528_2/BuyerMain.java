package work0528_2;

public class BuyerMain {

	public static void main(String[] args) {
		Buyer buyer = new Buyer();
		
		Tv tv = new Tv(1000);
		Computer com = new Computer(300);
		
		buyer.buy(tv);
		buyer.buy(com);
		System.out.println(buyer.money);
		System.out.println(buyer.bonusPoint);

	}

}
