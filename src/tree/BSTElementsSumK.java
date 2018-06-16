package tree;
import java.util.*;

class BSTElementsSumK extends TreeConstruction{
	ArrayList<Integer> inOrder = new ArrayList<Integer>();
	public static void main(String[] args) {
		BSTElementsSumK tree = new BSTElementsSumK();
		tree.populateBinarySearchTree();
		int k = 28;
		int[] result = new int[2];
		result = tree.findElementsSumK(tree.root, k);
		if(result.length > 0)
			System.out.println(result[0] + " " + result[1]);
	}
	public int[] findElementsSumK(TreeNode root, int k) {
		int[] result = new int[2];
		inOrderTraversal(root);
		int l = 0, r = inOrder.size() - 1;
		while(l < r) {
			int leftElement = inOrder.get(l);
			int rightElement = inOrder.get(r);
			int sum = leftElement + rightElement;
			if(sum == k) {
				result[0] = leftElement;
				result[1] = rightElement;
				return result;
			}
			if(sum < k)
				l++;
			else if(sum > k)
				r--;
				
		}
		return result;
	}
	public void inOrderTraversal(TreeNode root){
		if(root != null) {
			inOrderTraversal(root.left);
			inOrder.add(root.data);
			inOrderTraversal(root.right);
		}
	}
}