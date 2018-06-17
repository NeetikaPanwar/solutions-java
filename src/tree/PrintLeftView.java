package tree;

class PrintLeftView extends TreeConstruction{
	public static void main(String[] args) {
		PrintLeftView tree = new PrintLeftView();
		tree.populateTree();
		tree.leftView(tree.root);
	}
  public void leftView(TreeNode root)
    {
	  TreeNode temp = root;
        boolean prev = false, rightTakenFirst = false;
        int count = 0, attempt = 0;
        while(temp != null){
            if(prev){
                if(count == 0)
                    System.out.print(temp.data + " ");
                else
                    count--;
                if(temp.left == null && temp.right == null)
                	break;
                if(temp.left != null)
                    temp = temp.left;
                else if (temp.right != null)
                    temp = temp.right;
                continue;
            }
            else{
            System.out.print(temp.data + " ");
            if(temp.left == null && temp.right == null){
                prev = true;
                if(!rightTakenFirst)
                    temp = root.right;
                continue;
            }
               
            if(temp.left != null){
                temp = temp.left;
                count++;
                attempt++;
                
            }
            else if (temp.right != null){
                if(attempt == 0) rightTakenFirst = true;
                temp = temp.right;
                count++;
                attempt++;
                
            }
            }
        }
        System.out.println();
    }
}