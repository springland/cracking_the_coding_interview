package chapter4;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Given a sorted ( increasing order) array , write an algorithm to create a binary search tree with minimal height
 */
public class Question3 {

    public TreeNode toBinarySearchTree(int[] data)
    {
        if(data == null || data.length == 0)
        {
            return null ;
        }


        TreeNode node = toBinarySearchTree(data , 0 , data.length);

        return node;
    }

    public TreeNode toBinarySearchTree(int[] data , int startPos , int length)
    {
        if(length <= 0)
        {
            return null;
        }

        int middle = startPos + length /2 ;
        TreeNode node = new TreeNode();
        node.value = data[middle];

        node.leftChild = toBinarySearchTree(data , startPos , middle - startPos );
        node.rightChild = toBinarySearchTree(data , middle+1 , startPos +length -1 - middle );
        return node ;
    }

    @Test
    public void test1()
    {

        Question5  q5 = new Question5();
        TreeNode root = null;
        int[] data1 = {1};
        root = toBinarySearchTree(data1);
        assertTrue(q5.isBinarySearchTree(root));

        int [] data2 = {1 , 2 , 3};
        root = toBinarySearchTree(data2);
        assertTrue(q5.isBinarySearchTree(root));

        int [] data3 = {1 , 2 , 3 , 4};
        root = toBinarySearchTree(data3);
        assertTrue(q5.isBinarySearchTree(root));

    }
}
