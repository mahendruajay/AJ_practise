package cracking.programming.interview;

import java.util.*;
public class RemoveDuplicatesFromList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,1,1};
		LinkedListNode n = new LinkedListNode(array);
		removeDuplicatesNoBuff(n);
		n.printList();
		
		System.out.println("\n");
		LinkedListNode nn = new LinkedListNode(array);
		removeDuplicates(nn);
		nn.printList();

	}

	
	public  static void removeDuplicates(LinkedListNode n){
		
		Hashtable h = new Hashtable();
		ListNode curr = n.getHead();
		ListNode prev = null;
		
		while(curr != null){
			
			if(h.containsKey(curr.getData())){
				prev.setNext(curr.getNext());
				curr = curr.getNext();
			}
			else{
				h.put(curr.getData(),true);
				prev=curr;
				curr = curr.getNext();
				
			}
		}
	}
	
	public  static void removeDuplicatesNoBuff(LinkedListNode n){
	
		ListNode curr = n.getHead();
		ListNode runner = n.getHead();
		
		while(curr != null){
			
			while(runner.getNext() != null){
				if(runner.getNext().getData() == curr.getData()){
					runner.setNext(runner.getNext().getNext());
				}
				else{
				runner = runner.getNext();
				}
			}
			
			curr = curr.getNext();
			runner = curr;
		}
		
	}
}
