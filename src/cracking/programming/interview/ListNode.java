package cracking.programming.interview;

public class ListNode {
	
	int data;
	ListNode next;
	
	public ListNode (int data, ListNode node){
		this.data = data;		
		this.next = node;
		
	}
	
	public ListNode (){
		this.data = 0;		
		this.next = null;
		
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
	
	

}
