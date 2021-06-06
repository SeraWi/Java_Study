package work0606;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(5);
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(1);
		
		Iterator<Integer> itr= treeSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());//1,2,3,5,오르차순으로 정렬(기본)
		}
				
	}
}
