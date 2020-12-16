import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class NewQueue<Type> implements java.util.Queue<Type> {

    private int size = 0;
    private NewQueue.Node head = new NewQueue.Node();
    private NewQueue.Node back = null;

    private class Node {
        Type value = null;
        NewQueue.Node next;
        NewQueue.Node previous;

    }

    public NewQueue.Node Node(Type newValue) {
        NewQueue.Node node = new NewQueue.Node();
        node.value = newValue;
        node.next = null;
        node.previous = null;

        return node;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public boolean contains(Object o) {

        NewQueue.Node node = this.head;
        while (node != null)
        {
            if (o == node.value)
            {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    public Iterator<Type> iterator() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public boolean add(Type type) {

        if (back != null)
        {
            Node newNode = Node(type);
            newNode.previous = back;
            back.next = newNode;
            back = newNode;

        }
        else
        {
            head = Node(type);

        }
        size++;

        return false;
    }

    public boolean remove(Object o) {
        NewQueue.Node node = head;
        if (node.next != null)
        {
            head = node.next;
        }
        else
        {
            if (head.value != null)
            {
                clear();
            }
        }

        return true;
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public boolean addAll(Collection<? extends Type> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public void clear() {
        head = new Node();
        back = null;
        size = 0;
    }

    public boolean offer(Type type) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public Type remove() {
        NewQueue.Node node = head;
        if (node.next != null)
        {
            head = node.next;
        }
        else
        {
            if (head.value != null)
            {
                clear();
            }
        }

        if (node.value == null)
        {
            throw new UnsupportedOperationException("Queue is empty");
        }
        else
            return (Type) node.value;
    }

    public Type poll() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public Type element() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public Type peek() {
        throw new UnsupportedOperationException("This operation is not supported");
    }
}
