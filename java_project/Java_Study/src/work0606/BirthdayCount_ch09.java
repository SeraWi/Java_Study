package work0606;

import java.util.Calendar;
import java.util.Scanner;

public class BirthdayCount_ch09 {
	//4.자신의 생일을 기준으로 오늘까지 몇 일을 살았는지 출력하는 프로그램을 만들어봅시다.
	public static void main(String[] args) {
		
		Calendar today = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("태어난 해를 입력하세요.");
		int year = Integer.parseInt(scanner.nextLine());
		System.out.println("태어난 달을 입력하세요.");
		int month = Integer.parseInt(scanner.nextLine());
		System.out.println("태어난 날을 입력하세요.");
		int day = Integer.parseInt(scanner.nextLine());
		
		birthday.set(year,month,day);
		
		long difference = (today.getTimeInMillis() - birthday.getTimeInMillis())/(1000*24*60*60);
		System.out.println(difference +"일을 살았습니다.");
		
		
	}
}
