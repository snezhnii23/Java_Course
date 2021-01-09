import static org.junit.Assert.*;

public class TreeMapTest {

    public static void main(String[] args)
    {
        TreeMap<Integer, Integer> bt = new TreeMap<>();

        bt.put(5, 5);
        bt.put(2, 56);
        bt.put(6, 34);

        assertEquals(bt.containsKey(5), true);
        bt.remove(5);
        assertEquals(bt.containsKey(8), false);
        bt.put(5, 76);
        assertEquals(bt.containsKey(5), true);
    }

}