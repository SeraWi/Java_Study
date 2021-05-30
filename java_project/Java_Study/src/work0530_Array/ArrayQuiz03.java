package work0530_Array;

public class ArrayQuiz03 {

	static void change(int[][] arr) {
		int[] tmp = arr[arr.length-1]; 
		for(int i= arr.length-1; i>0; i-- ) {
			arr[i] = arr[i-1];
		}
		arr[0] = tmp;
	}
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		for( int [] tmp: arr) {
			for( int i: tmp) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		change(arr);
		System.out.println("=================");
		for( int[] tmp : arr) {
			for(int i: tmp) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
