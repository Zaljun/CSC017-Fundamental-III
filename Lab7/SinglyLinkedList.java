
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
    
    //swap two nodes
	private void swap(ListNode a, ListNode b)
	{
		ListNode dummy = new ListNode(-1);
		dummy.next     = head;
		ListNode pre   = dummy;
		
		ListNode aPrv  = pre;
		ListNode bPrv  = pre;
		
		while(aPrv.next != a)
		    aPrv = aPrv.next;
		ListNode aAft  = a.next;
		while(bPrv.next != b)
		    bPrv = bPrv.next;
		ListNode bAft  = b.next;
		
		aPrv.next = b;
		b.next    = aAft;
		bPrv.next = a;
		a.next    = bAft;
	}
	
	private void testSwap(int x, int y)
	{
		ListNode dummy = new ListNode(-1);
		dummy.next     = head;
		ListNode pre   = dummy;
		
		ListNode a     = head;
		ListNode b     = head;
		ListNode aPrv  = pre;
		ListNode bPrv  = pre;

		for(int i = 0; i < x; i++)
		    a     = a.next;
		for(int i = 0; i < y; i++)
		    b     = b.next;
		    
		while(aPrv.next != a)
		    aPrv = aPrv.next;
		ListNode aAft  = a.next;
		while(bPrv.next != b)
		    bPrv = bPrv.next;
		ListNode bAft  = b.next;
		
		aPrv.next = b;
		b.next    = aAft;
		bPrv.next = a;
		a.next    = bAft;
	
	}
	
    //partition list
    private void partition(int x)
    {
		
		ListNode itr   = head;
		ListNode mark  = head;
		ListNode s     = head;
		while(itr.next != null)
		{
			if(itr.val > x)
			    mark = itr;
			if(itr.val <= x)
			{
				s    = itr;
				swap(mark,s);
				mark = s.next;
			}
			itr = itr.next;
		}
	}
	
	//remove a node
	private void remove(ListNode r)
	{
		ListNode prv = head;
		if(prv == r)
		    head = head.next;
		else
		{
			while(prv.next != r)
			prv = prv.next;
			prv.next = r.next;
		}
	}
	
	
	
	//remove duplicate from sorted list
	private void removeDup()
	{
		ListNode itr = head;
		ListNode prv = head;
		while(itr.next != null)
		{
			prv = itr;
			itr = itr.next;
			if(prv.val == itr.val)
			remove(prv);
		}
	}
	
	//remove all duplicate from sorted list
	private void removeDup_all()
	{
		int dup;
		ListNode itr = head;
		ListNode prv = head;
		while(itr.next != null)
		{
			prv = itr;
			itr = itr.next;
			if(prv.val == itr.val)
			{
				dup = prv.val;
				remove(prv);
				while(itr.val == dup)
				{
					prv = itr;
					itr = itr.next;
					remove(prv);
				}
			}
		}
	}
    
    public static void main(String args[]) {
		
		//remove duplicate test
    	SinglyLinkedList list1 = new SinglyLinkedList();
    	int arr[] ={5,4,4,3,3,2,1};
    	for(int i = 0; i < 7; i++)
    	{
			list1.add(arr[i]);
		}
		System.out.println(list1);
		list1.removeDup();
		System.out.println(list1);
		
		//remove duplicate_all test
		SinglyLinkedList list2 = new SinglyLinkedList();
		int arr2[] ={5,4,4,3,3,2,1};
    	for(int i = 0; i < 7; i++)
    	{
			list2.add(arr2[i]);
		}
		System.out.println(list2);
		list2.removeDup_all();
		System.out.println(list2);
		
		//swap by index test 
		SinglyLinkedList list3 = new SinglyLinkedList();
		int arr3[] ={2,5,2,3,4,1};
    	for(int i = 0; i < 6; i++)
    	{
			list3.add(arr3[i]);
		}
		System.out.println(list3);
		list3.testSwap(5,1);
		System.out.println(list3);
		list3.testSwap(5,0);
		System.out.println(list3);
		
		//partition test
		SinglyLinkedList list4 = new SinglyLinkedList();
		int arr4[] ={2,5,2,3,4,1};
    	for(int i = 0; i < 6; i++)
    	{
			list4.add(arr4[i]);
		}
		System.out.println(list4);
		list4.partition(3);
		System.out.println(list4);

    }
}
