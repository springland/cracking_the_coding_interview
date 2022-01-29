package chapter4;

public class TreeNode {

    public String name ;
    public TreeNode leftChild ;

    public TreeNode rightChild ;

    public TreeNode parent ;
    public int value ;

    public TreeNode()
    {

    }


    public TreeNode(int value)
    {
        this.value = value ;
    }

    public TreeNode(String name , int value)
    {
        this.name = name ;
        this.value = value ;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(" name :").append(this.name).append(", value:").append(value);
        return builder.toString();
    }
}
