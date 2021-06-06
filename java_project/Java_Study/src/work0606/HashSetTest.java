package work0606;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		//HashSet 저장 공간 생성:
		//인스턴스 저장, 중복 저장을 허용하지 않는다.
		//저장순서를 저장하지 않는다.
		
		HashSet<String>hashset = new HashSet<>();
		
		//데이터 저장
		hashset.add("First");
		hashset.add("Second");
		hashset.add("Third");
		hashset.add("First");
		
		//데이터 일괄 처리
		Iterator<String> itr = hashset.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		HashSet<Integer> hashset2 = new HashSet<>();
		hashset2.add(1); //auto boxing
		hashset2.add(2); 
		hashset2.add(1); 
		hashset2.add(2); 
		hashset2.add(3); 
		
		Iterator<Integer>itr2 = hashset2.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
				
	}
}
