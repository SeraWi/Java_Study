package work0530_inheritance;

public class BuyerMain {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer2());
		b.buy(new Audio());
		b.buy(new Tv());
		b.buy(new Computer2());
		b.buy(new Audio());
		b.summary();
	}
}
