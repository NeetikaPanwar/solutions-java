package tree;
import java.util.*;
class PreOrderTraversalNonRecursive extends TreeConstruction{
	public static void main(String[] arg) {
		PreOrderTraversalNonRecursive tree = new PreOrderTraversalNonRecursive();
		tree.populateTree();
		tree.preOrderTraversal(tree.root);
	}
	
	public void preOrderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
	}
}

