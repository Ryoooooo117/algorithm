// find the least number of square numbers of a given ’n’

public class dp1 {
	
	public int numSquares(int n) {
        int num = (int) Math.sqrt(n), weight = n;
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        for( int i = 1 ; i <= n ; i++ ){
        	int min = n;
        	for( int j = 1; j <= num ; j++ ){
        		if( i-j*j >=0 ){
        			min = Math.min(min,dp[i-j*j]+1);
        		}
        	}
        	dp[i] = min;
        }
        return dp[n];
    }
	
	public void test(){
		for( int n = 0 ; n < 100 ; n++ ){
			int res = numSquares(n);
			System.out.println("res: "+res);
		}
	}

}
