package work0606;

public class PersonalNumberTest_ch09 {
	//위 Person 클래스의 equals() 메소드를 오버라이딩해서 주민등록번호가 같으면 인스턴스로 판별하는 프로그램을 만들어봅시다.
	public static void main(String[] args) {
		
		Person p1 = new Person("손흥민", "1111-11111");
		Person p2 = new Person("이수지", "1111-11111");
		
		System.out.println(p1.equals(p2));
		
	}
}
class Person {
	String name;
	String personNumber;
	
	Person(String name, String personNumber){
		this. name = name;
		this.personNumber = personNumber;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result  = false;
		
		if(!(obj == null) && obj instanceof Person) {
			Person p = (Person)obj;
			if(this.personNumber == p.personNumber) {
				result = true;
			}
		}
		return result;
	}
	
}
