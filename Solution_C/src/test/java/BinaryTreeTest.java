import static org.junit.Assert.*;

public class BinaryTreeTest {

    public static void main(String[] args)
    {
        BinaryTree<Integer, Integer> bt = new BinaryTree<>();

        bt.add(5, 5);
        bt.add(2, 56);
        bt.add(6, 34);

        assertEquals(bt.isContains(5), true);
        bt.remove(5);
        assertEquals(bt.isContains(8), false);
        bt.add(5, 76);
        assertEquals(bt.isContains(5), true);
    }

}