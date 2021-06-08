package work0608;

import java.util.Scanner;
/*
 * Ex_Exception
 */
public class NameInputTest {
	
	public static boolean checkChar(String name) {
		boolean result = true;
		
		for(int i = 0; i<name.length();i++) {
			char c = name.charAt(i);
			if(!(c >= 'a'&& c<= 'z' || c >='A'&& c<='Z'|| 
					c>= '0' && c <='9')) {
				result = false;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름을 입력해주세요");
		String name = scanner.nextLine();
		
		//이름이 잘못 입력 될 경우 오류 발생 시키기
		if(name != null && !name.trim().isEmpty()) {
			//isEmpty(): 문자열의 길이가 0인 경우 true를 리턴합니다.
			//빈 공백이 들어있는 문자열은 false를 리턴
			if(checkChar(name)) {
				System.out.println("입력하신 이름은: "+name);
			}else {
				try {
					throw new BadInputException("잘못된 이름 입력 오류");
				} catch (BadInputException e) {
					System.out.println(e.getMessage());
				}
			}
		}else {
			System.out.println("이름이 입력되지 않았습니다.");
		}
	}
}



class BadInputException extends Exception{
	public BadInputException(String msg) {
		super(msg);
	}
}