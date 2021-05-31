package work0531_Interface;

public class NumberMain {
	public static void main(String[] args) {
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);
		
		storage.addPersonalInfo("손흥민", "950000-1122333");
		storage.addPersonalInfo("박지성", "970000-1122334");
		
		System.out.println(storage.searchName("950000-1122333"));
		System.out.println(storage.searchName("970000-1122334"));
	}
}
