package cracking.coding.interview;

public class KthLastelement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,4,5,45,566,3};
		LinkedListNode n = new LinkedListNode(array);		
		kthLastElemRecursive(n.getHead(),4);
		System.out.println(kthLastElem(n.getHead(),4).getData());
	}
	
	
	public static int kthLastElemRecursive(ListNode n,int k){
		
		if(n == null)
		 return 0;
		
		int i = kthLastElemRecursive(n.getNext(),k) +1;
		
		if(i == k){
			System.out.println(n.getData());
		}
		
		return i;		
		
	}
	
	public static ListNode  kthLastElem(ListNode n,int k){
		
		ListNode curr = n;
		ListNode kth = n;
		
		
		for(int i =0; i<k-1;i++){
			
			if (kth.getNext() != null){
				kth=kth.getNext();
			}
			else{
				return null;
			}
		}
		
		while(kth.getNext() != null){
			curr = curr.getNext();
			kth = kth.getNext();
		}
		
		return curr;
		
	}
	



}
