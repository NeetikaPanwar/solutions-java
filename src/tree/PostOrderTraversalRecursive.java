package tree;

class PostOrderTraversalRecursive extends TreeConstruction{
	public static void main(String[] args) {
		PostOrderTraversalRecursive tree = new PostOrderTraversalRecursive();
		tree.populateTree();
		tree.preOrderTraversal(tree.root);
	}
	public void preOrderTraversal(TreeNode root) {
		if(root != null) {
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}
}