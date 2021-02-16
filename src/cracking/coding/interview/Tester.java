package cracking.coding.interview;

public class Tester {

	
	public static void main(String[] args){
		 
		//System.out.print(UniqueCharTest.isUniqueChar("sdfghjkll"));
		
		int[] dataArr = {8,13,12};
		Tree t = new Tree();
		t.buildTree(dataArr);
		
		System.out.println("In order : ");
		t.inOrder();
		
		System.out.println("Post order : ");
		t.postOrder();
		
		System.out.println("Pre order : ");
		t.preOrder();
		
		System.out.println("tree height : " + t.getHeight());
		
		System.out.println("Is tree BST : " + t.isBinarySearchTree());
		

		
		
	}
}
