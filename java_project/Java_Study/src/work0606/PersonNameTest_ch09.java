package work0606;

import java.util.Scanner;

public class PersonNameTest_ch09 {
	//	3.사용자에게 이름을 입력 받아 입력 받은 문자열을 정상적인 문자열의 이름으로 표현하는지 판별하고, 
	//	공백으로 입력되었는지도 판별하는 프로그램을 만들어봅시다.


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("이름을 입력하세요.");
		String name = scanner.nextLine();

		if(!(name.trim() == name)) {
			System.out.println("이름에 공백이 입력되었습니다.");
		}else {
			System.out.println("안녕하세요. "+name+"님");
		}
	}
}
