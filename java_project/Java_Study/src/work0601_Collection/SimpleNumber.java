package work0601_Collection;

import java.util.*;

public class SimpleNumber {

	int num;
	public SimpleNumber(int n) {
		num = n;
	}
	public String toString() {
		return String.valueOf(num);
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		SimpleNumber comp = (SimpleNumber) obj;
		if(comp.num == num) {
			result = true;
		}
		return result;
	}
	@Override
	public int hashCode() {
		return num % 3;
	}
	
	
	public static void main(String[] args) {
		HashSet<SimpleNumber> hSet = new HashSet<SimpleNumber>();
		hSet.add(new SimpleNumber(10));
		hSet.add(new SimpleNumber(20));
		hSet.add(new SimpleNumber(20));
		
		System.out.println("저장된 데이터 수: "+hSet.size());
		Iterator<SimpleNumber> itr = hSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
}
