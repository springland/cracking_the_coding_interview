package chapter3;

import lombok.Data;

@Data
public class Node {


    Node next = null;
    Object  data;

    public Node(Object d)
    {
        data = d ;
    }
}

