package tree;

class TreeConstruction{
	public TreeNode root;
	
	public static void main(String[] arg) {
		TreeConstruction tree = new TreeConstruction();
		tree.populateTree();
		tree.populateBinarySearchTree();
		System.out.println(tree.root.data);
	}
	public void populateTree() {
		root = new TreeNode(8);
		root.left =  new TreeNode(3);
		root.right =  new TreeNode(10);
		root.left.left =  new TreeNode(1);
		root.left.right =  null;
		root.right.left =  new TreeNode(6);
		root.right.right =  new TreeNode(14);
		root.right.left.left =  new TreeNode(4);
		root.right.left.right =  new TreeNode(7);
		root.right.right.left =  new TreeNode(13);
	}
	public void populateBinarySearchTree() {
		root = new TreeNode(15);
		root.left =  new TreeNode(10);
		root.right =  new TreeNode(20);
		root.left.left =  new TreeNode(8);
		root.left.right =  new TreeNode(12);
		root.right.left =  new TreeNode(16);
		root.right.right =  new TreeNode(25);
	}
}

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
}