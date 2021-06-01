package work0601_Collection;

import java.util.Iterator;
import java.util.TreeSet;

class Person implements Comparable<Person>{
	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void showData() {
		System.out.printf("%s %d \n", name, age);
	}

	@Override
	public int compareTo(Person p) {
//		if(age > p.age) {
//			return 1;
//		}else if( age < p.age) {
//			return -1;
//		}else {
//			return 0;
//		}
		return this.age - p.age;
	}
}

public class ComparablePerson {
	
	public static void main(String[] args) {
		TreeSet<Person> sTree = new TreeSet<Person>();
		sTree.add(new Person("LEE",24));
		sTree.add(new Person("Kim",20));
		sTree.add(new Person("Kang",28));
		sTree.add(new Person("LEE",15));
		
		Iterator<Person> itr = sTree.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}
	}
}
