package cracking.coding.interview;


public class AddTwoLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] int1 = {8,9,8,7,3};
		LinkedListNode n1 = new LinkedListNode(int1);
		
		int[] int2 = {0,2,1,3,4};
		LinkedListNode n2 = new LinkedListNode(int2);
		
		LinkedListNode res = new LinkedListNode();
		res.setHead(addTwoLsitsRecursive(n1.getHead(),n2.getHead(),0).getN());
		res.printList();

	}
	
	public static SumNode addTwoLsitsRecursive(ListNode n1, ListNode n2, int carr){
		
		ListNode curr = new ListNode();
		
		if(n1.getNext() == null && n2.getNext() ==null){
			int sum = n1.getData() + n2.getData();
			curr.setData((sum + carr)%10);
			carr = sum/10;
			
			SumNode s = new SumNode(curr, carr);
			return s;
		}
		
		SumNode q = addTwoLsitsRecursive(n1.getNext(),n2.getNext(),carr);
		curr.setNext(q.getN());		
		curr.setData((n1.getData() + n2.getData() + q.getCarr())%10);
		carr = (n1.getData() + n2.getData() + q.getCarr())/10;
		
		SumNode s = new SumNode(curr, carr);
		return s;
	}
	

}

//Need to return both sum and carry so defined this class

class SumNode{
	
	ListNode n;
	int carr;
	
	public SumNode(ListNode n, int carr){
		this.n = n;
		this.carr = carr;
	}

	public ListNode getN() {
		return n;
	}

	public void setN(ListNode n) {
		this.n = n;
	}

	public int getCarr() {
		return carr;
	}

	public void setCarr(int carr) {
		this.carr = carr;
	}
}