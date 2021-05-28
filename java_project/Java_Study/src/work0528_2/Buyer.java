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
	void summary() {
		//구매 상품 리스트, 구매 금액의 총합 출력
		int sum = 0;
		int bonusPoint =0;
		String itemList ="";
		
		for( int i= 0; i < cnt; i++) {
			sum+= item[i].price;
			bonusPoint += item[i].bonusPoint;
			itemList +=item[i]+",";
		}
		System.out.println("구매하신 제품은"+itemList+ " 입니다.");
		System.out.println("구매하신 제품의 총 금액은 "+ sum+ "원 입니다.");
		System.out.println("구매하신 제품의 적립 포인트는 "+ bonusPoint+ "점 입니다.");
	}
}




