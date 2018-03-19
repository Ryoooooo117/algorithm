
public class DPLCS {
	
	public static int lcs(String s1,String s2){
		int[][] dp = new int[s1.length()][s2.length()];
		for( int i = 0 ; i < s2.length() ; i++ ){
			if( s1.charAt(0) == s2.charAt(i) )
				dp[0][i] = 1;
		}
		for( int i = 0 ; i < s1.length() ; i++ ){
			if( s2.charAt(0) == s1.charAt(i) )
				dp[i][0] = 1;
		}
		for( int i = 1; i < s1.length() ; i++ ){
			for( int j = 1; j < s2.length() ; j++ ){
				if( s1.charAt(i)==s2.charAt(j) ){
					//dp[i][j] = dp[i-1][j-1]+1; subsequence
					if( s1.charAt(i-1)==s2.charAt(j-1) ){
						dp[i][j] = dp[i-1][j-1]+1;
					}
					else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[s1.length()-1][s2.length()-1];
	}
	
	public static void main(String[] args){
		String s1 = "acbcbaef";
		String s2 = "abcbced";
		
		int res = lcs(s1,s2);
		System.out.println(res);
		
	}

}
