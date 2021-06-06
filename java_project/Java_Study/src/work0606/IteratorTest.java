package work0606;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(); //다형성
		
		//요소 저장:add(T t);
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");
		
		for(int i= 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-----------------------");
		for(String str: list) {
			System.out.println(str);
		}
		System.out.println("------------------------");
		
		Iterator<String >itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
				
	}
}
