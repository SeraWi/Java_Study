package work0530_Array;

public class ArrayTest {
	public static void main(String[] args) {
		int[][] arr = {
				{1,2},
				{3,4,5},
				{6,7,8,9}
		};
		System.out.println("배열의 세로 길이: "+arr.length);
		
		for( int i= 0; i< arr.length; i++) {
			System.out.println("가로 길이: "+ arr[i].length);
		}
	}
}
