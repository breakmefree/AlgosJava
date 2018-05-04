package leet.code.medium;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 * 
 * @author knidhi
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbersLinkedList {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int carry = 0;
        ListNode node = new ListNode(0);
        ListNode curr = null;
        
        while(l1 != null || l2 != null)
        {
            int sum = carry;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if(curr == null) {
                curr = node;
            } else {
                curr.next = new ListNode(0);
                curr = curr.next;
            }
            curr.val = sum % 10;
            carry = sum / 10;
        }
        if(carry != 0){
            curr.next = new ListNode(0);
            curr = curr.next;
            curr.val = carry;
        }
        return node;
	}

	public static void main(String[] args) {
		//[2,4,3]
		//[5,6,4]
		
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(4);
		
		System.out.println(addTwoNumbers(l1, l2));
	}

}
