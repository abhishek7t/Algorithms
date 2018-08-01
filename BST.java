package ch12;

public class BST {
	TreeNode root;
	public static void inorderTreeWalk(TreeNode x)
	{
		if(x != null)
		{
			inorderTreeWalk(x.left);
			System.out.println(x.item);
			inorderTreeWalk(x.right);
		}
	}
	
	public static TreeNode treeSearch(TreeNode x, int k)
	{
		if(x == null || k == x.item)
		{
			return x;
		}
		if(k < x.item)
		{
			return treeSearch(x.left, k);
		}
		else
		{
			return treeSearch(x.left, k);
		}
	}
	
	public static TreeNode iterativeTreeSearch(TreeNode x, int k)
	{
		while(x != null && k != x.item)
		{
			if(k < x.item)
			{
				x = x.left;
			}
			else
			{
				x = x.right;
			}
		}
		return x;
	}
	
	public static TreeNode treeMinimum(TreeNode x)
	{
		while(x.left != null)
		{
			x = x.left;
		}
		return x;
	}
	
	public static TreeNode treeMaximum(TreeNode x)
	{
		while(x.right != null)
		{
			x = x.right;
		}
		return x;
	}
 
	public static TreeNode treeSuccessor(TreeNode x)
	{
		if(x.right != null)
		{
			return treeMinimum(x.right);
		}
		TreeNode y = x.p;
		while(y != null && x == y.right)
		{
			x = y;
			y = y.p;
		}
		return y;
	}
	
	public static TreeNode treePredecessor(TreeNode x)
	{
		if(x.left != null)
		{
			return treeMinimum(x.left);
		}
		TreeNode y = x.p;
		while(y != null && x == y.left)
		{
			x = y;
			y = y.p;
		}
		return y;
	}
	
	public void treeInsert(TreeNode z)
	{
		TreeNode y = null;
		TreeNode x = root;
		while(x != null)
		{
			y = x;
			if(z.item < x.item)
			{
				x = x.left;
			}
			else
			{
				x = x.right;
			}
		}
		z.p = y;
		if(y == null)
		{
			root = z;
		}
		else if (z.item < y.item)
		{
			y.left = z;
		}
		else
		{
			y.right = z;
		}
	}
	
	private void transplant(TreeNode u, TreeNode v)
	{
		if(u.p == null)
		{
			root = v;
		}
		else if(u == u.p.left)
		{
			u.p.left = v;
		}
		else
		{
			u.p.right = v;
		}
		
		if(v == null)
		{
			v.p = u.p;
		}
	}

	public void treeDelete( TreeNode z)
	{
		if(z.left == null)
		{
			transplant(z, z.right);
		}
		else if (z.right == null)
		{
			transplant(z, z.left);
		}
		else
		{
			TreeNode y = treeMinimum(z.right);
			if(y.p != z)
			{
				transplant(y, y.right);
				y.right = z.right;
				y.right.p = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.p = y;
		}
	}
}
