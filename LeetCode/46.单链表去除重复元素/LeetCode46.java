package code;

public class LeetCode46{
	public static void main(String args[]){
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(2);
		ListNode list4 = new ListNode(4);
		ListNode list5 = new ListNode(4);
		
		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;
		
		ListNode list = deleteDuplicates(list1);
		while(list != null){
			System.out.println(list.val);
			list = list.next;
		}
	}


	//删除排序链表中重复的元素
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode left = head;
		ListNode right = head.next;
		
		if(head == null || head.next == null){
			return head;
		}
		
		while(right.next != null){
			if(left.val == right.val){
				right = right.next;
				left.next = right;
			}
			if(left.val != right.val){
				right = right.next;
				left = left.next;
			}
		}
		
		//由于前面不能对最后的两个元素进行判断，所以再进行一次判断
		if(left.val == right.val){
			left.next = null;
		}
		
		return head;
	}
	
}
	