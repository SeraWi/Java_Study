package work0530_inheritance;

public class Buyer {
	int money;
	int bonusPoint;
	Product[] item;
	int numOfitem = 0;
	Buyer() {
		this.money = 1000;
		this.bonusPoint = 0;
		item = new Product[10];
	}
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -=p.price;
		bonusPoint += p.bonusPoint;
		item[numOfitem++] = p;
		System.out.println(p+"을/를 구입하셨습니다. ");
	}
	void summary() {
		int sum = 0;
		String itemList ="";

		for(int i = 0; i< numOfitem ; i++) {
			if(item[i] == null) {
				break;
			}else {
				sum+= item[i].price;
				itemList+=item[i]+" ";

			}
		}
		System.out.println("구입하신 물품의 총금액은 "+sum+"입니다");
		System.out.println("구입하신 제품은 "+itemList+"입니다.");
	}
}
