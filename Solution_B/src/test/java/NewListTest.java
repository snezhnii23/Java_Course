import org.junit.Test;

import static org.junit.Assert.*;

public class NewListTest {

    @Test
    public void size() {
        NewList<Integer> list = new NewList<Integer>();

        int size = list.size();
        assertEquals(size, 0);
        list.add(5);
        size = list.size();
        assertEquals(size, 1);
    }

    @Test
    public void isEmpty() {
        NewList<Integer> list = new NewList<Integer>();

        boolean id = list.isEmpty();
        assertEquals(id, true);
        list.add(5);
        id = list.isEmpty();
        assertEquals(id, false);
    }

    @Test
    public void contains() {
        NewList<Integer> list = new NewList<Integer>();

        list.add(6);
        boolean id1 = list.contains(6);
        boolean id2 = list.contains(5);

        assertEquals(id1, true);
        assertEquals(id2, false);
    }

    @Test
    public void add() {
        NewList<Integer> list = new NewList<Integer>();

        list.add(6);
    }

    @Test
    public void clear() {
        NewList<Integer> list = new NewList<Integer>();

        list.add(6);
        list.clear();

        boolean id = list.isEmpty();
        assertEquals(id, true);
    }

    @Test
    public void get() {
        NewList<Integer> list = new NewList<Integer>();

        list.add(6);
        int output = list.get(1);
        assertEquals(output, 6);

        output = list.get(6);
        assertEquals(output,null);
    }

    @Test
    public void addIndex() {

    }

    @Test
    public void testAdd() {
    }

    @Test
    public void remove() {
        NewList<Integer> list = new NewList<Integer>();

        list.add(6);
        list.remove(1);

        boolean id = list.isEmpty();
        assertEquals(id, true);
    }

    @Test
    public void indexOf() {
        NewList<Integer> list = new NewList<Integer>();

        list.add(6);
        list.add(7);
        list.add(2, 8);

        int index = list.indexOf(8);
        int index2 = list.indexOf(9);

        assertEquals(index, 2);
        assertEquals(index2, 0);

    }
}