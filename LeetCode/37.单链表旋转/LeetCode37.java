package code;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode37{
	
	public static void main(String args[]){
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode list3 = new ListNode(3);
		ListNode list4 = new ListNode(4);
		ListNode list5 = new ListNode(5);
		
		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;
		
		ListNode list = rotateRight(list1, 2);
		while(list != null){
			System.out.println(list.val);
			list = list.next;
		}

	}


	//�ҵ����һ�����ʵĳ���
	public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        
        //p->1->2->3->4->5
        
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = root;
        ListNode q = root;
        
        for(int i = 0; i <= n; i++){
        	p = p.next;
        }
        
        // �ҵ���һ��Ҫ�����Ľ���ǰ��
        // qΪ��һ��Ҫ�����Ľ���ǰ��
        while (p != null) {
            p = p.next;
            q = q.next;
        }

        p = q;
        q = root;
        if (p != null && p.next != null) { // ��Ҫλ�ƵĽ��
            ListNode node;
            while (p.next != null) {
                // ժ�����
                node = p.next;
                p.next = node.next;
                // ���Ͻ��
                node.next = q.next;
                q.next = node;
                q = node; // ���һ���ƶ��Ľڵ�
            }
        }

        return root.next;
        
	}

}
	