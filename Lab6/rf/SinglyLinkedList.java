
public class SinglyLinkedList {
	
	// reference that points to the list head
	public ListNode head;
	
	// nested class for singly-list node
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
		}
		ListNode(int x, ListNode nextIn) { 
			this.val = x;
			this.next = nextIn;
		}
	}
	
	public SinglyLinkedList() {
		head = null;
	}
	
	// add node to the head of list
	private void add(int val) {
		ListNode e = new ListNode(val, head);
		head = e;
		
	}
	
	public String toString() {
   	 	String mylist = "";
   	 	ListNode e = head;
   	 	while(e != null) {
   	 		mylist = mylist + e.val + " ";
   	 		e = e.next;
   	 }
   	 return mylist;
	}
	
    private void reverseList() {
    	if(head == null) return;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        head = prev;
    }
    
    private void reverseBetween(int m, int n) {
        if(head == null) return;
        ListNode dummy = new ListNode(-1); 
        dummy.next = head;
        ListNode pre = dummy; 
        for(int i = 0; i<m-1; i++) pre = pre.next;
        
        ListNode start = pre.next; 
        ListNode then = start.next; 

        
        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        head = dummy.next;

    }
    
    public static void main(String args[]) {
    	SinglyLinkedList list1 = new SinglyLinkedList();
    	for(int i = 10; i > 0; i--) {
    		list1.add(i);
    	}
    	System.out.println(list1);
    	list1.reverseList();
    	System.out.println(list1);
    	list1.reverseList();
    	System.out.println(list1);
    	list1.reverseBetween(3,7);
    	System.out.println(list1);
    }
}
