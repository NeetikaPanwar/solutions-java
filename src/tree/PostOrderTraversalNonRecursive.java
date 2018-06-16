package tree;
import java.util.*;

class PostOrderTraversalNonRecursive extends TreeConstruction{
	public static void main(String[] args) {
		PostOrderTraversalNonRecursive tree = new PostOrderTraversalNonRecursive();
		tree.populateTree();
		tree.postOrderTraversal(tree.root);
	}
	public void postOrderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null, curr = null;
		stack.push(root);
	
		while(!stack.isEmpty()) {
			curr = stack.peek();
			if(prev == null || prev.left == curr || prev.right == curr) {
				if(curr.left != null)
					stack.push(curr.left);
				else if(curr.right != null)
					stack.push(curr.right);
			}
			else if(prev == curr.left) {
				if(curr.right != null)
					stack.push(curr.right);
			}
			else {
				System.out.print(curr.data + " ");
				stack.pop();
			}
			prev = curr;
		}
	}
}