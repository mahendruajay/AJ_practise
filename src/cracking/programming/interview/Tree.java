package cracking.programming.interview;

public class Tree {

	Node root;
	
	public void buildTree(int[] dataArr){
	
		if(dataArr == null){
			this.root = null;	
		}
		
		this.root = formTree(dataArr,0,dataArr.length-1); 
		
	}
	
	private Node formTree(int[] dataArr, int start, int end){
		
		if(end<start)
			return null;		
				
		int mid = (start + end)/2;
		Node n = new Node(dataArr[mid]);
		n.left = formTree(dataArr, start, mid-1);
		n.right = formTree(dataArr, mid+1,end);
		
		return n;
	}
	
	public void buildBST(int[] dataArr){
		
	}
	
	
	private void buildBST(){
		
	}
	
	public void preOrder(){
		
		preOrder(this.root);
	}
	
	private void preOrder(Node node){
		
		if(node == null){
			return;
		}
		
		System.out.println(node.data);
		preOrder(node.left);		
		preOrder(node.right);	
		
	}
	
	public void postOrder(){
	
		postOrder(this.root);
	}
	
	private void postOrder(Node node){
		
		if(node == null){
			return;
		}		
		postOrder(node.left);		
		postOrder(node.right);
		System.out.println(node.data);
		
	}
	
	public void inOrder(){
		
		inOrder(this.root);
			
	}
	
	private void inOrder(Node node){
		
		if(node == null){
			return;
		}
		
		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);
		
	}
	
	
	
	public void balanceTree(){
		
	}
	
	public boolean isBalanced(){
		
		if(this.root==null){
			return true;
		}
		
		
		return false;
		
	}
	
	public int getHeight(){
	
		return getHeight(this.root);
	}
	
	private int getHeight(Node node){
		
		if(node == null){
			return 0;
		}
		
		return Math.max(getHeight(node.left), getHeight(node.right)) +1;		
	}
	
	public boolean isBinarySearchTree(){
		
		int lastInorder = Integer.MIN_VALUE;
		isBinarySearchTree(this.root,lastInorder);		
		return false;
		
	}
	
	private boolean isBinarySearchTree(Node node, int lastInorder){	
	
		if(node == null)
			return true;
		
		
		
		if(!isBinarySearchTree(node.left, lastInorder)){
			return false;
		}

		if(lastInorder>node.data){
			return false;
		}
		
		lastInorder = node.data;
		
		if(!isBinarySearchTree(node.right, lastInorder)){
			return false;
		}
		
		return true;
				
	}
	
	
	public boolean isBSTByminMax(){
		return false;
	}
	
	
	public void dfsTraversal(){
		
	}
	
	public void bfsTranversal(){
		
	}
	
	public Node findSuccessor(Node n){
	
		return null;
	}
	
	public Node firstCommonAncestor(Node first, Node second){
		
		return null;
	}
	
}

