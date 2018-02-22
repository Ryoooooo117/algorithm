
import java.util.*;

public class MaxHeap {
    
    public int findKthLargest(int[] nums, int k) {
        creatHeap(nums);
        show(nums);
        for( int i = 1, n = nums.length ; i < k ; i++){
            heapDelete(nums,n--);
            show(nums);
        }
        return nums[0];
    }
    
    public void creatHeap(int[] nums){
        int n = nums.length;
        for( int i = (n-2)/2 ; i>=0 ; i-- ){
            heapAdjust(nums,i,n);
        }
    }
    
    public void heapAdjust(int[] heap, int top, int n){
        int l = top*2+1;
        int temp = heap[top];
        
        while( l < n ){
            // r = heap[l+1], get the Max(l,r)
            if( l+1 < n && heap[l+1] > heap[l] ) l++;
            if( heap[l] > temp ){
                heap[top] = heap[l];
                //heap[l] = temp;
                top = l;
                l = top*2+1;
            }
            else break;
        }
        heap[top] = temp;
    }
    
    public void heapDelete(int[] heap,int n){
        if( n < 0 ) return;
        heap[0] = heap[n-1];
        heapAdjust(heap,0,n-1);
    }
    
    void show(int[] nums){
        for( int i : nums ){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    public void test(){
        int[] nums = {3,2,1,5,6,4};
        //int[] nums = {1,2,3,4,5,6,7,8,9,10};
        //int[] nums = {5,9,1,8,2,7,3,4,6,0};
        //int[] nums = {2,1};
        int k = 2;
        int res = findKthLargest(nums,k);
        System.out.println("res: "+res);
    }
}
