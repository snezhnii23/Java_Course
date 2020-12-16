import org.junit.Test;

import static org.junit.Assert.*;

public class NewQueueTest {

    @Test
    public void isEmpty() {
        NewQueue<Integer> queue = new NewQueue<Integer>();

        assertEquals(queue.isEmpty(), true);

        queue.add(6);
        assertEquals(queue.isEmpty(), false);
    }

    @Test
    public void add() {

    }

    @Test
    public void remove() {
        NewQueue<Integer> queue = new NewQueue<Integer>();

        queue.add(6);
        int output = queue.remove();
        assertEquals(output, 6);
    }
}