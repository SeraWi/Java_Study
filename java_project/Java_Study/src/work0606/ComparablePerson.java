package work0606;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparablePerson {
	public static void main(String[] args) {
		TreeSet<Person2> set = new TreeSet<>();
		//데이터 저장
		
		set.add(new Person2("Lee",25));
		set.add(new Person2("Hong",34));
		set.add(new Person2("Park",15));
		set.add(new Person2("kim",7));
		
		Iterator<Person2> itr = set.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}
	}
}
class Person2 implements Comparable<Person2>{
	String name;
	int age;
	
	//생성자
	Person2(String name, int age){
		this.name= name;
		this.age= age;
	}
	
	public void showData() {
		System.out.println(this.name+","+this.age);
	}

	@Override
	public int compareTo(Person2 o) {
//		if(this.age>age) {
//			return 10000;
//		}else if(this.age < o.age) {
//			return -1;
//		}else {
//			return 0;
//		}
		
	//	return this.age- o.age; //오름차순 정렬
		return o.age- this.age; //내림차순 정렬
	}
	
	
}