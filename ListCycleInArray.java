
import java.util.*;

public class ListCycleInArray {
    
    public int findDuplicate(int[] nums) {
        if( nums.length < 1) return -1;
        int fast = nums[nums[0]];
        int slow = nums[0];
        while( fast != slow ){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        slow = 0;
        while( fast != slow ){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for( int i : nums ){
            if( set.contains(i) ) return i;
            else set.add(i);
        }
        return -1;
    }
    
    public void test(){
        int[] nums = {1,5,3,4,5,2,6};
        int res = findDuplicate(nums);
        System.out.println("res: "+res);
    }
}
