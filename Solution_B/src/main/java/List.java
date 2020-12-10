import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class List {

    private Node head = new Node();
    private Node back = null;

    public class Node {
        private Object element = 0;
        private Node next = null;
        private Node previous = null;

        public int addElement(Object Element) {
            Node node = new Node();
            node.element = Element;
            node.next = null;
            node.previous = null;

            if (back != null) {
                node.previous = back;
                back.next = node;
            }
            if (back == null) {
                head = node;
            }
            back = node;

            return 1;
        }

        public Object getElement(Node inputNode, int position) {
            Node node = inputNode;
            while (node != back && position > 1) {
                node = node.next;
                position--;
            }
            if (position == 1)
                return node.element;
            else
                return null;
        }

        public Node getNext() {
            return next;
        }

        public int eraseElement(Node inputNode, int position) {
            Node node = inputNode;
            if (node == null) {
                return 1;
            }
            while (node != back && position > 1) {
                node = node.getNext();
                position--;
            }
            if (position == 1) {
                if (node == back) {
                    back = node.previous;
                    back.next = null;
                } else {
                    Node nextNode = node.next;
                    nextNode.previous = node.previous;
                    Node previousNode = node.previous;
                    previousNode.next = node.next;
                }
                return 1;
            } else
                return 0;
        }

        public Node findElement(Node inputNode, Object count) {
            Node node = inputNode;
            while (node != back) {
                if (node.element == count) {
                    return node;
                }
                node = node.next;
            }
            if (node.element == count) {
                return node;
            } else {
                return null;
            }
        }

        public int insertPosition(Node inputNode, Object count, int position) {
            Node node = inputNode;
            while (node != back && position > 1) {
                node = node.getNext();
                position--;
            }
            if (position == 1) {
                Node nextNode = node;
                Node previous = node.previous;
                Node newNode = new Node();

                newNode.element = count;
                newNode.previous = previous;
                newNode.next = node;

                previous.next = newNode;
                node.previous = newNode;

                return 1;
            } else
            {
                if (position == 2)
                {
                    addBack(count);

                    return 1;
                }
                else
                    return 0;
            }
        }

    }

    public int addBack(Object count) {
        head.addElement(count);

        return 1;
    }

    public int erase(int position) {
        if (position >= 1) {
            if (position == 1) {
                head = head.next;
            } else
                head.eraseElement(head, position);

            return 1;
        } else
            return 0;
    }

    public int find(Object count) {
        if (head.findElement(head, count) != null) {
            return 1;
        } else
            return 0;
    }

    public int isEmpty() {
        if (head == null) {
            return 1;
        } else
            return 0;
    }

    public Object get(int position) {
        return head.getElement(head, position);
    }

    public int insert(Object count, int position) {
        return head.insertPosition(head, count, position);
    }

    public int print() {
        System.out.print("List -  [");
        Node node = head;
        while (node != null) {
            System.out.print(node.element);
            System.out.print(" | ");
            node = node.next;
        }
        System.out.println("]");

        return 1;
    }

    public String toString()
    {
        if (head == null)
            return "[]";

        String string = "[";
        List.Node node = head;
        while (node.next != null)
        {
            string += node.element.toString() + ", ";
            node = node.next;
        }
        string += node.element.toString() + "]";

        return string;
    }

}

