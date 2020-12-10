import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void push() {
        Queue queue = new Queue();

        queue.push(1);
        String out1 = queue.toString();
        queue.push("Tet");
        String out2 = queue.toString();
        System.out.println(out1);
        String need1 = "[1]";
        String need2 = "[1, Tet]";
        assertEquals(out1, need1);
        assertEquals(out2, need2);
    }

    @Test
    public void erase() {
        Queue queue = new Queue();

        queue.push(1);
        queue.push("Tet");
        queue.push(1.0676);
        String out1 = queue.toString();
        queue.erase();
        String out2 = queue.toString();
        queue.erase();
        String out3 = queue.toString();

        String need1 = "[1, Tet, 1.0676]";
        String need2 = "[Tet, 1.0676]";
        String need3 = "[1.0676]";

        assertEquals(out1, need1);
        assertEquals(out2, need2);
        assertEquals(out3, need3);
    }

    @Test
    public void isEmpty() {
        Queue queue = new Queue();

        int out1 = queue.isEmpty();
        queue.push(1);
        int out2 = queue.isEmpty();

        assertEquals(out1, 1);
        assertEquals(out2, 0);
    }
}