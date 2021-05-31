package work0531_Collection;

import java.util.ArrayList;

public class IntroArrayList {
	public static void main(String[] args) {
		ArrayList <Integer> list = new ArrayList<Integer>();
		// 데이터의 저장
		list.add(new Integer(11));
		list.add(new Integer(22));
		list.add(new Integer(33));
		// 데이터의 참조
		for( int i= 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		//데이터의 삭제
		System.out.println("------------------");
		list.remove(0);
		for(int i= 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
