package Interview;

public class Knapsack {
	public static int knapsack(int[] weights, int [] values, int capacity) {
		int n= weights.length;
		int[][] arr= new int[n+1][capacity +1];
		
		for(int i=1;i<=n;i++) {
			for(int w=1;w<=capacity; w++ ) {
				if(weights[i-1]<=w) {
					arr[i][w]=Math.max(arr[i-1][w], arr[i-1][w -weights[i-1]] +values[i-1]);
				}
				else {
					arr[i][w]=arr[i-1][w];
				}
			}
		}
		return arr[n][capacity];
	}
	public static void main(String[] args) {
		int[] weights= {1,2,3};
		int[] values= {10,15,40};
		int capacity=6;
		int maxvalue=knapsack(weights, values, capacity);
		System.out.println(maxvalue);
		
	}

}
