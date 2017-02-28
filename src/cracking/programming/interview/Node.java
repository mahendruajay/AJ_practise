package cracking.programming.interview;

enum State{VISITED,UNVISITED,VISITING}

public class Node {

	int data;
	Node left;
	Node right;
	Node parent;
	State state;
	
	public Node(int data){
		this.data =data;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.state = State.UNVISITED;
	}
	
}


