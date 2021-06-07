package work0607;

public class Ex_Array04 {
	
	public static void addOneDArr(int[] arr, int add) {
		for(int i= 0; i<arr.length; i++) {
			arr[i] += add;
		}
	}
	
	public static void addOneDArr(int[][] arr, int add) {
		for(int i= 0; i<arr.length; i++) {
			for( int j =0; j<arr[i].length; j++) {
				arr [i][j] += add;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3,4,5},
				{2,3,4,5,6},
				{5,6,7,8,9},
				{2,4,5,6,7}
		};
		
		addOneDArr(arr, 8);
		
		for(int[] tmp : arr) {
			for(int tmp2 :tmp) {
				System.out.print(tmp2+" ");
			}
			System.out.println();
		}
		
	}
}
