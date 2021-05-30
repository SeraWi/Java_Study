package work0530_Array;


public class ArrayQuiz02 {
	public static void addOneDArr(int [] arr, int add) {
		for(int i = 0; i< arr.length; i++) {
			arr[i] += add;
		}
	}
	public static void addOneDarr(int[][]arr, int add) {
		for(int i =0; i< arr.length; i++) {
			for(int j = 0; j< arr[i].length; j++) {
				arr[i][j] += add;
			}
		}
	}
	public static void main(String[] args) {
		int [][] arr = {
				{1,2,3,4,5},
				{5,4,3,2,1},
				{5,6,7,8,9},
				{9,8,7,6,5},
				{1,2,3,4,5}
		};
		
		for(int[] tmp : arr) {
			for(int i : tmp) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		addOneDarr(arr, 10);
		System.out.println("==================");
		for( int[]tmp: arr) {
			for(int i: tmp) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
