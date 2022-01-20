package chapter3;

public class Stack {

    String name ;
    Node top ;
    int size = 0;

    public Stack()
    {

    }

    public Stack(String name)
    {
        this.name = name ;
    }

    public String getName()
    {
        return this.name ;
    }


    public Object pop()
    {
        if(top != null)
        {
            Object item = top.data;
            top = top.next ;
            size --;
            return item ;
        }

        return null ;
    }

    public void push(Object item)
    {
        Node node = new Node(item);
        node.next = top;
        top = node ;
        size ++;
    }

    public int getSize()
    {
        return size ;
    }

    public Node peek()
    {
        return top;
    }
}
