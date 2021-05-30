package work0530_Array;

import java.util.Scanner;

public class ArrayQuiz01 {
	
	public static int minValue(int[] arr) {
		int min = arr[0];
		for( int i= 0; i< arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	public static int maxValue(int[] arr) {
		int max = arr[0];
		for (int i = 0; i< arr.length; i++) {
			if( arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arr = new int [5];
		for( int i= 0; i < arr.length; i++) {
			System.out.print("숫자를 입력해주세요 > ");
			int inputNum = Integer.parseInt(scanner.nextLine());
			arr[i] = inputNum;
		}
		System.out.println("최대값: "+ maxValue(arr));
		System.out.println("최소값: "+ minValue(arr));
	}
}
