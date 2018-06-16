package tree;

class TreeConstruction{
	public TreeNode root;
	
	public static void main(String[] arg) {
		TreeConstruction tree = new TreeConstruction();
		tree.populateTree();
		System.out.println(tree.root.data);
	}
	public void populateTree() {
		root = new TreeNode(1);
		root.left =  new TreeNode(2);
		root.right =  new TreeNode(3);
		root.left.left =  new TreeNode(4);
		root.left.right =  new TreeNode(5);
		root.right.left =  new TreeNode(6);
		root.right.right =  new TreeNode(7);
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