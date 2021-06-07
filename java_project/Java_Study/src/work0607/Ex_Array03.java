package work0607;

import java.util.Scanner;

public class Ex_Array03 {

	public static int minValue(int[] arr) {//최소값 반환
		int min = arr[0];
		for(int i = 0 ; i < arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}

	public static int maxValue(int[] arr) {// 최대값 반환
		int max = arr[0];
		for(int i = 0; i< arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}


	public static void main(String[] args) {
		//정수는 프로그램 사용자로부터 입력받기

		Scanner scanner = new Scanner(System.in);

		System.out.println("입력할 정수의 갯수를 입력하세요.");
		int num = Integer.parseInt(scanner.nextLine());


		int[] arr = new int[num];

		for(int i=0; i < num; i++) {
			System.out.println("임의 정수를 입력해주세요.");
			int randomNum = Integer.parseInt(scanner.nextLine());
			arr[i] = randomNum;
		}
		
		System.out.println("최소값"+ minValue(arr));
		System.out.println("최대값"+ maxValue(arr));

	}
}
