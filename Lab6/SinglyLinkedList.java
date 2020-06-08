public class SinglyLinkedList
{
	public ListNode head;
	private static class ListNode
	{
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
		ListNode(int x, ListNode nextIn) 
		{
			this.val  = x;
			this.next = nextIn;
		}
	}
	
	public SinglyLinkedList() {head = null;}
	private void add(int val)
	{
		ListNode e = new ListNode(val, head);
		head = e;
	}
	public String toString()
	{
		String mylist = "";
		ListNode e = head;
		while(e != null)
		{
			mylist = mylist + e.val + " ";
			e = e.next;
		}
		return mylist;
	}
	
	private void reverseList()
	{
		//my code
		ListNode bfr = head;
		ListNode cur = head.next;
		ListNode aft = cur.next;
		head.next    = null;
		while(aft   != null)
		{
			cur.next = bfr;
			bfr = cur;
			cur = aft;
			aft = aft.next;
		}
		cur.next = bfr;
		head     = cur;
	}
	private void reverseBetween(int m, int n)
	{
		//my code
		ListNode revBtw_bfr = head;
		ListNode revBtw_aft = head;
		if(m > 1){
		for(int i = 0; i < m-2; i++)
		{
			revBtw_bfr = revBtw_bfr.next;
		}
	    }
	    else {
			ListNode rev = new ListNode(0,head);
			revBtw_bfr = rev;}
	    if(n < 10){
		for(int i = 0; i < n; i++)
		{
			revBtw_aft = revBtw_aft.next;
		}
	    }
	    else {revBtw_aft = null;}
		ListNode bfr = revBtw_bfr.next;
		ListNode cur = bfr.next;
		ListNode aft = cur.next;
		bfr.next     = revBtw_aft;
		while(aft   != revBtw_aft)
		{
			cur.next = bfr;
			bfr = cur;
			cur = aft;
			aft = aft.next;
		}
		cur.next = bfr;
		revBtw_bfr.next = cur;
	}
	
	public static void main(String args[])
	{
		SinglyLinkedList list1 = new SinglyLinkedList();
		for(int i = 10; i > 0; i--)
		{
			list1.add(i);
		}
		System.out.println(list1);
		list1.reverseList();
		System.out.println(list1);
		list1.reverseList();
		System.out.println(list1);
		list1.reverseBetween(1,10);
		System.out.println(list1);
	}
}
