package leetcode;

import java.util.Stack;

public class ReverseLinkedListWithO(1)space {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head, fast = head;
		if( head == null ) return true;
		Stack<Integer> stack = new Stack<Integer>();
		while( fast.next !=null && fast.next.next !=null ){
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("slow :"+slow.val);
		if( fast.next == null ){
			System.out.println("odd:");
		}
		else if(fast.next.next == null){
			stack.push(slow.val);
			System.out.println("even: ");
		}
		slow = slow.next;
		while( slow != null ){
			if( stack.pop() != slow.val ) return false;
			slow = slow.next;
		}
        return true;
    }
	
	public void test(){
		ListNode head = new ListNode(-1);
		ListNode p = head;
		p.next = new ListNode(1); p = p.next;
		p.next = new ListNode(2); p = p.next;
		p.next = new ListNode(3); p = p.next;
		p.next = new ListNode(5); p = p.next;
		p.next = new ListNode(3); p = p.next;
		p.next = new ListNode(2); p = p.next;
		p.next = new ListNode(1); p = p.next;
		p = null;
		
		boolean res = isPalindrome(head.next);
		System.out.println("res: "+res);
	}
}
