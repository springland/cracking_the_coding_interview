package chapter4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Implement a function to check if a binary tree is balanced. For purpose of this question
 * a balance tree is defined to be a tree such that the heights of two subtree of any node
 * never differ by more than one
 */
public class Question1 {

    public boolean isBalanced(TreeNode root)
    {


        int height = getHeight(root);

        if(height < 0)
        {
            return false;
        }
        return true ;
    }

    protected int   getHeight(TreeNode root)
    {
        if(root == null)
        {
            return 0 ;
        }

        int leftHeight = getHeight(root.leftChild);
        int rightHeight = getHeight(root.rightChild);
        if(leftHeight < 0 || rightHeight < 0 )
        {
            return -2 ;
        }

        if(leftHeight > rightHeight +1 || rightHeight > leftHeight+1)
        {
            return -2 ;
        }


        return 1 + Math.max(leftHeight , rightHeight) ;
    }
    @Test
    public void test()
    {
        TreeNode root = null;
        assertTrue(isBalanced(root));

        root = new TreeNode();

        root.leftChild = new TreeNode();
        assertTrue(isBalanced(root));

        root.leftChild.leftChild = new TreeNode();
        assertFalse(isBalanced(root));

        root.leftChild.rightChild = new TreeNode();
        assertFalse(isBalanced(root));

        root.rightChild = new TreeNode();
        assertTrue(isBalanced(root));

    }
}


