package ch12;

public class Testing {
	public static void main(String[] args)
	{
		BST tree = new BST();
		int[] items = {2,3,4,6,7,13,9,15,17,18,20};
		for(int item : items)
		{
			TreeNode z = new TreeNode();
			z.item = item;
			z.left = null;
			z.right = null;
			tree.treeInsert(z);
		}
		BST.inorderTreeWalk(tree.root);
		TreeNode z = BST.iterativeTreeSearch(tree.root, 18);
		tree.treeDelete(z);
		BST.inorderTreeWalk(tree.root);
		
	}
}
