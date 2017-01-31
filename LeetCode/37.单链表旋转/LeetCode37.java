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


	//找到最后一定单词的长度
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
        
        // 找到第一个要交换的结点的前驱
        // q为第一个要交换的结点的前驱
        while (p != null) {
            p = p.next;
            q = q.next;
        }

        p = q;
        q = root;
        if (p != null && p.next != null) { // 有要位移的结点
            ListNode node;
            while (p.next != null) {
                // 摘除结点
                node = p.next;
                p.next = node.next;
                // 接上结点
                node.next = q.next;
                q.next = node;
                q = node; // 最后一个移动的节点
            }
        }

        return root.next;
        
	}

}
	