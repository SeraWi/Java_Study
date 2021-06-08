package work0608;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Ex_Exception
 * InputMismatchException: 정수로 입력해야 하는데 문자를 입력한 경우 예외 발생
 */
public class NumberInputTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("숫자를 입력해주세요.");

		try {
			//예외가 발생할 가능성이 있는 코드를 입력
			int number = scanner.nextInt();
			System.out.println("입력하신 숫자는:" + number);
		}catch(InputMismatchException e){
			//InputMismatchException발생할 경우 예외를 받아온다.
			System.out.println("입력하시는 데이터는 숫자가 아닙니다.");
		}
		System.out.println("프로그램 종료");
	}
}