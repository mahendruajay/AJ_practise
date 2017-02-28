package cracking.programming.interview;



public class LinkedListNode {

	ListNode head;
	int length;
	ListNode tail;
	
	
	
		
	public LinkedListNode(){	
		this.head = null;
		this.length = 0;
		this.tail = null;
	
	}
	
	
	public LinkedListNode(int[] array){	
		
		this.setHead(null);
		this.setLength(0);
		this.setTail(null);
		
		if (null != array && array.length >0){
		  
			this.setHead(new ListNode(array[0],null));
			this.setLength(1);
			
			ListNode curr = this.head; 
			int length = array.length - 1;
			int i= 1;
			while(length > 0){
				curr.setNext(new ListNode(array[i],null));
				this.setLength(this.length++);
				this.setTail(curr.getNext());
				curr = curr.getNext();
				length--;
				i++;
			}
		}
		
		
	
	}

	
	public void printList(){
		
		ListNode curr = this.getHead();
		while(curr != null){
			System.out.print(curr.getData()+" -> ");
			curr = curr.getNext();
		}
		
	}

	public ListNode getHead() {
		return head;
	}


	public void setHead(ListNode head) {
		this.head = head;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public ListNode getTail() {
		return tail;
	}


	public void setTail(ListNode tail) {
		this.tail = tail;
	}
	
	
}
