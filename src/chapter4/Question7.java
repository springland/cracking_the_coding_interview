package chapter4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure.  Note. this is not necessary a binary search tree
 */
public class Question7 {

    public TreeNode findCommonAncestor(TreeNode root , TreeNode node1 , TreeNode node2)
    {

        if(root == null )
        {
            return root ;
        }
        if(node1 == null || node2 == null)
        {
            return null;
        }

        TreeNode leftChild =  findCommonAncestor(root , root.leftChild , node1 , node2);
        TreeNode rightChild = findCommonAncestor(root , root.rightChild , node1 , node2);


        if(leftChild != null && rightChild != null)
        {
            return root ;
        }

        if(leftChild != null && leftChild != node1 && leftChild != node2)
        {
            return leftChild;
        }
        if(rightChild != null && rightChild != node1 && rightChild != node2)
        {
            return rightChild;
        }

        return null;
    }


    protected TreeNode findCommonAncestor(TreeNode root ,TreeNode parent , TreeNode node1 , TreeNode node2)
    {

        if(parent == null)
        {
            return parent ;
        }
        if(parent == node1 || parent == node2)
        {
            return parent ;
        }


        TreeNode leftSearch = findCommonAncestor(root , parent.leftChild , node1 , node2);
        TreeNode rightSearch = findCommonAncestor(root , parent.rightChild , node1 , node2);

        if(leftSearch != null  && rightSearch != null)
        {
            return parent ;
        }

        if(leftSearch != null )
        {
            if(parent != root) {
                return leftSearch;
            }
            else
            {
                if(leftSearch != node1 && leftSearch!= node2)
                {
                    return leftSearch ;
                }
            }
        }
        if(rightSearch != null)
        {
            if(parent != root) {
                return rightSearch;
            }
            else
            {
                if(rightSearch != node1 && rightSearch != node2)
                {
                    return rightSearch ;
                }
            }
        }
        return null ;

    }
    @Test
    public void test()
    {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.leftChild = node1;

        assertNull(findCommonAncestor(root , node1 , node2));
        root.rightChild = node2 ;
        assertEquals(root , findCommonAncestor(root , node1 , node2));

        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node2.leftChild = node3;
        node2.rightChild = node4;

        assertEquals(node2 , findCommonAncestor(root , node3 , node4));

        TreeNode node5 = new TreeNode(5);
        node4.rightChild = node5;
        TreeNode node6 = new TreeNode(6);
        node5.rightChild = node6;

        assertEquals(node2 , findCommonAncestor(root , node3 , node6));

        TreeNode node7 = new TreeNode(7);
        node6.leftChild = node7 ;
        assertEquals(node2 , findCommonAncestor(root , node3 , node7));
    }
}
