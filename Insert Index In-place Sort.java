package leetcode;

public class Insert Index In-place Sort {
	
	/*
	public void moveZeroes2(int[] nums) {
		int n = nums.length;
        for( int i = 0 ; i < n ; i++ ){
        	if( nums[i] == 0 && i+1 < n ){
        		int j = i+1;
        		while(nums[j]==0 && j+1 < n) j++;
        		nums[i] = nums[j];
        		nums[j] = 0;
        		if( j == n-1 ) break;
        		i--;
        	}
        }
    }
	*/
	
	public void moveZeroes(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0){
	        	nums[insertPos++] = num;
	        }
	    }        
	    
	    show(nums);

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
	
	
	public void show(int[] nums){
		for( int i : nums ){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public void test(){
		int[] nums = {0,1,0,3,12};
		show(nums);
		moveZeroes(nums);
		show(nums);
	}

}
