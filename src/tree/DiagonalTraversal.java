package tree;
import java.util.*;

class DiagonalTraversal extends TreeConstruction{
	public static void main(String[] args) {
		DiagonalTraversal tree = new DiagonalTraversal();
		tree.populateTree();
		tree.diagonalTraversal(tree.root);
	}
	
	public void diagonalTraversal(TreeNode root) {
		Queue<TreeNode> q1 = new LinkedList<>();
		TreeNode temp = root;
		while(temp != null) {
			q1.add(temp);
			temp = temp.right;
		}
		Queue<TreeNode> q2 = new LinkedList<>();
		while(!q1.isEmpty()) {
			try {
				TreeNode node = q1.remove();
				System.out.print(node.data + " ");
				if(node.left != null) {
					q2.add(node.left);
					if(node.left.right != null)
						q2.add(node.left.right);
				}
			
				if(q1.isEmpty()) {
					q1 = new LinkedList<>(q2);
					q2.clear();
					System.out.println();
				}
			}
			catch(Exception e) {
				System.out.println("exception " + e);
			}
		}
	}
}