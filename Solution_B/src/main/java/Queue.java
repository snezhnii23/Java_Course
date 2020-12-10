import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue {

    private Node head = new Node();
    private Node back = null;

    public class Node {
        private Object element = 0;
        private Node next = null;
        private Node previous = null;

        public int addElement(Object Element)
        {
            Node node = new Node();
            node.element = Element;
            node.next = null;
            node.previous = null;

            if (back != null) {
                node.previous = back;
                back.next = node;
            }
            if (back == null)
            {
                head = node;
            }
            back = node;

            return 1;
        }

        public Node getNext() {
            return next;
        }

        public int eraseElement(Node inputNode)
        {
            Node node = inputNode;
            if (node.next != null)
            {
                head = node.next;
                head.previous = null;
            }

            return 1;
        }

    }

    public int push(Object count)
    {
        head.addElement(count);

        return 1;
    }

    public int erase()
    {
        head.eraseElement(head);

        return 1;
    }


    public int isEmpty()
    {
        if (back == null)
        {
            return 1;
        }
        else
            return 0;
    }



    public int print()
    {
        System.out.print("Queue - [");
        Node node = head;
        while (node != null)
        {
            System.out.print(node.element);
            System.out.print(" | ");
            node = node.next;
        }
        System.out.println("]");

        return 1;
    }

    public String toString()
    {
       String string = "[";
        Node node = head;
        while (node.next != null)
        {
            string += node.element.toString() + ", ";
            node = node.next;
        }
        string += node.element.toString() + "]";

        return string;
    }
}

