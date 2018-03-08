
import java.util.*;

public class MonotonicQueue {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if( nums.length < 1 || k <= 0 ) return new int[0];
		int[] res = new int[nums.length-k+1];
		LinkedList<Integer> l = new LinkedList<Integer>();

		for( int i = 0 ; i < nums.length ; i++ ){
			while( !l.isEmpty() && nums[i]>=nums[l.getLast()] ){
				l.removeLast();
			}
			l.addLast(i);
			if( i - l.getFirst() + 1 > k ){
				l.removeFirst();
			}
			if( i-k+1 >= 0 ){
				res[i-k+1] = nums[l.getFirst()];
			}
		}
        return res;
    }
	
	public void show(int[] nums){
		System.out.println("nums");
		for( int i : nums ){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public void test(){
		//int[] nums = {1,3,2,1,-3,5,3,6,7,4};
		int[] nums = {1,3,-1,-3,-4,5,3,6,7};
		//int[] nums = {1};
		int k = 3;
		show(nums);
		int[] res = maxSlidingWindow(nums,k);
		show(res);
	}
}
