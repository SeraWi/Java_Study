package work0606;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class SimpleNumber{
	int num;
	SimpleNumber(int num){
		this.num = num;
	}
	@Override
	public String toString() {
		return String.valueOf(num);
	}
	@Override
	public int hashCode() {
		return num%3; //0,1,2-> 세개의 그룹으로 나눠짐
	}
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj != null && obj instanceof SimpleNumber) {
			SimpleNumber sNum = (SimpleNumber) obj;
			if(this.num == sNum.num) {
				result = true;
			}
		}
		return result;
	}
}

public class HashSetTest02 {
	public static void main(String[] args) {
		Set<SimpleNumber> hashSet = new HashSet<>();
		
		//데이터 저장
		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(20));
		hashSet.add(new SimpleNumber(30));
		hashSet.add(new SimpleNumber(10));
		hashSet.add(new SimpleNumber(20));
		hashSet.add(new SimpleNumber(40));
		
		//데이터 일괄 처리
		Iterator<SimpleNumber> itr = hashSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
