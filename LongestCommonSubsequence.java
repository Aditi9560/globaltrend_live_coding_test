package Interview;

public class LongestCommonSubsequence {
	public static int longestCommonSubsequence(String s1, String s2) {
		int m=s1.length();
		int n=s2.length();
		
		int arr[][]=new int[m+1][n+1];
		
		for(int i= 1; i<=m; i++) {
			for(int j=1; j<=n;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					arr[i][j]=arr[i-1][j-1]+1;
					
				}
				else {
					arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		return arr[m][n];
	}
	
	public static void main(String[] args) {
		String s1="abcde";
		String s2="ace";
		int lcs=longestCommonSubsequence(s1, s2);
		System.out.println("length of lcs is = " +lcs);
		
	}

}
