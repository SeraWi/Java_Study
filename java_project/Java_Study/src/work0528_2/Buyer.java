package work0528_2;

public class Buyer {
	int money;
	int bonusPoint;
	Product[] item;
	int cnt;
	
	Buyer(){
		this.money = 10000;
		this.bonusPoint =0;
		this.item = new Product[10];
		this.cnt =0;
		
	}
	void buy(Product p) {
		//보유 금액을 확인하고 구매 여부 체크
		if(money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return; //return의 의미: 메소드 종료, 값의 반환
		}
		this.money -= p.price;
		this.bonusPoint += p.bonusPoint;
		item[cnt] = p;
		cnt++;
		System.out.println(p +"를 구매 하였습니다.");
	}
	
}
