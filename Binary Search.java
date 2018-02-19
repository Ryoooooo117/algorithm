
public class Binary Search {
	
	public int searchInsert(int[] nums, int target) {
		if( nums.length == 0 ) return 0;
        int l = 0, r = nums.length-1;
        while( l <= r ){
            int mid = (l+r)/2;
            if( target > nums[mid] ){
                l = mid+1;
            }
            else if( target < nums[mid] ){
                r = mid-1;
            }
            else return mid;
        }
        return l;
    }
	
	public void test(){
		int[] nums = {1,2,3,4,5};
		int target = 6;
		int res = searchInsert(nums,target);
		System.out.println("res:"+res);
	}
}
