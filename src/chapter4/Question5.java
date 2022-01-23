package chapter4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Implement a function to check if a binary tree is a binary search tree
 */
public class Question5 {

    public boolean isBinarySearchTree(TreeNode root)
    {

        boolean isBinarySearchTree = true ;

        if(root == null)
        {
            return isBinarySearchTree ;
        }

        isBinarySearchTree  &= isBinarySearchTree(root.leftChild  , Integer.MIN_VALUE , root.value);

        isBinarySearchTree  &= isBinarySearchTree(root.rightChild , root.value , Integer.MAX_VALUE);

        return isBinarySearchTree;
    }

    protected boolean isBinarySearchTree( TreeNode node , int minValue , int maxValue)
    {
        if( node == null)
        {
            return true ;
        }
        if(node.value < minValue || node.value > maxValue)
        {
            return false ;
        }

        boolean isBinarySearchTree = true ;
        if(node.leftChild != null)
        {
            isBinarySearchTree = isBinarySearchTree(node.leftChild , minValue , node.value);
        }

        if(node.rightChild != null && isBinarySearchTree)
        {
            isBinarySearchTree &= isBinarySearchTree(node.rightChild , node.value , maxValue);
        }
        return isBinarySearchTree ;

    }

    @Test
    public void testIsBinarySearchTree()
    {
        TreeNode root = new TreeNode(10);
        root.leftChild = new TreeNode(8);
        root.leftChild.leftChild = new TreeNode(6);
        root.leftChild.rightChild = new TreeNode(9);


        assertTrue(isBinarySearchTree(root));

        root.rightChild = new TreeNode(20);
        assertTrue(isBinarySearchTree(root));

        root.rightChild.rightChild = new TreeNode(40);
        assertTrue(isBinarySearchTree(root));

        root.rightChild.rightChild.rightChild = new TreeNode(60);
        assertTrue(isBinarySearchTree(root));

    }

    @Test
    public void testIsNotBinarySearchTree()
    {
        TreeNode root = new TreeNode(10);
        root.leftChild = new TreeNode(8);
        root.rightChild = new TreeNode(12);
        root.leftChild.leftChild = new TreeNode(6);
        root.leftChild.rightChild = new TreeNode(9);
        root.leftChild.rightChild.rightChild = new TreeNode(7);
        assertFalse(isBinarySearchTree(root));

        root = new TreeNode(10);
        root.leftChild = new TreeNode(8);
        root.leftChild.leftChild = new TreeNode(6);
        root.leftChild.rightChild = new TreeNode(9);

        root.rightChild = new TreeNode(12);
        root.rightChild.rightChild = new TreeNode(9);



        assertFalse(isBinarySearchTree(root));

        root = new TreeNode(10);
        root.rightChild = new TreeNode(6);
        assertFalse(isBinarySearchTree(root));

        root = new TreeNode(10);
        root.leftChild = new TreeNode(12);
        assertFalse(isBinarySearchTree(root));
    }
}
