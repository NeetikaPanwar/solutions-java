package tree;

class PreOrderTraversalRecursive extends TreeConstruction{
	public static void main(String[] args) {
		PreOrderTraversalRecursive tree = new PreOrderTraversalRecursive();
		tree.populateTree();
		tree.preOrderTraversal(tree.root);
	}
	public void preOrderTraversal(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
}