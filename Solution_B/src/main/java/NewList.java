import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NewList<Type> implements java.util.List<Type> {

    private int size = 0;
    private Node head = new Node();
    private Node back = null;

    private class Node {
        Type value = null;
        Node next;
        Node previous;

    }

    public Node Node(Type newValue) {
        Node node = new Node();
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

        Node node = this.head;
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

    public boolean add(Type element) {
        Node node = head;

        if (head.value == null) {
            head.value = element;
            size++;
            back = head;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            Node newNode = Node(element);
            newNode.value = element;
            newNode.previous = node;
            node.next = newNode;

            size++;
        }

        return true;
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public boolean addAll(Collection<? extends Type> c) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public boolean addAll(int index, Collection<? extends Type> c) {
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
        head.value = null;
        size = 0;
    }

    public Type get(int index) {
        if (index < 0 && index > size) {
            throw new UnsupportedOperationException("Invalid index");
        }
        Node node = head;
        int position = index - 1;
        if (node.value != null) {
            while (node != null && position != 0) {
                position--;
                node = node.next;
            }
            if (position == 0) {
                if (node != null)
                    return node.value;
                else
                    throw new UnsupportedOperationException("Invalid index");
            } else
                throw new UnsupportedOperationException("Invalid index");
        } else {
            throw new UnsupportedOperationException("List is empty");
        }
    }

    public Type set(int index, Type element) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public void add(int index, Type element) {
        if (index < 0 && index > size) {
            throw new UnsupportedOperationException("Invalid index");
        }

        Node node = head;
        int position = index - 1;
        if (head.value != null) {
            while (node != null && position != 0) {
                position--;
                node = node.next;
            }
            if (position == 0) {
                if (node != null) {
                    Node newNode = Node(element);
                    newNode.previous = node;
                    node.previous.next = newNode;
                    if (node.next != null) {
                        newNode.next = node.next;
                        node.next.previous = newNode;
                    }

                    size++;
                } else {
                    add(element);
                }
            } else
                throw new UnsupportedOperationException("Invalid index");
        } else {
            if (position == 1) {
                add(element);
            } else
                throw new UnsupportedOperationException("Invalid index");
        }
    }

    public Type remove(int index) {
        if (index < 0 || index > size) {
            throw new UnsupportedOperationException("Invalid index");
        }

        Node node = head;
        int position = index - 1;
        if (node != null) {
            while (node != null && position != 0) {
                position--;
                node = node.next;
            }

            if (position == 0) {
                if (node != null) {
                    if (node.next != null) {
                        Node nextNode = node.next;
                        Node previousNode = node.previous;
                        if (previousNode != null) {
                            if (nextNode != null) {
                                previousNode.next = nextNode;
                                nextNode.previous = previousNode;

                                size--;
                            } else {
                                previousNode.next = null;

                                size--;
                            }
                        } else {
                            if (nextNode != null) {
                                head = nextNode;
                                head.previous = null;

                                size--;
                            } else {
                                clear();
                            }
                        }
                    }
                } else {
                    throw new UnsupportedOperationException("Invalid index");
                }
            } else {
                throw new UnsupportedOperationException("Invalid index");
            }
        }

        return null;
    }

    public int indexOf(Object element) {
        Node node = head;
        int index = 1;
        while (node != null && node.value != element) {
            node = node.next;
            index++;
        }
        if (node != null) {
            if (node.value == element) {
                return index;
            } else
                throw new UnsupportedOperationException("Magic mistake");
        } else
            return 0;
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public ListIterator<Type> listIterator() {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public ListIterator<Type> listIterator(int index) {
        throw new UnsupportedOperationException("This operation is not supported");
    }

    public List<Type> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("This operation is not supported");
    }
}
