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


	//ɾ�������������ظ���Ԫ��
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
		
		//����ǰ�治�ܶ���������Ԫ�ؽ����жϣ������ٽ���һ���ж�
		if(left.val == right.val){
			left.next = null;
		}
		
		return head;
	}
	
}
	