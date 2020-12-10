import static org.junit.Assert.*;

public class ListTest {

    @org.junit.Test
    public void addBack() {
        List list = new List();

        list.addBack(1);
        String out1 = list.toString();
        list.addBack("Tet");
        String out2 = list.toString();
        String need1 = "[1]";
        String need2 = "[1, Tet]";

        assertEquals(out1, need1);
        assertEquals(out2, need2);
    }

    @org.junit.Test
    public void erase() {
        List list = new List();

        list.addBack(1);
        list.addBack("Tet");
        list.erase(1);
        String out1 = list.toString();
        list.erase(2);
        String out2 = list.toString();
        list.erase(1);
        String out3 = list.toString();

        String need1 = "[Tet]";
        String need2 = "[Tet]";
        String need3 = "[]";

        assertEquals(out1, need1);
        assertEquals(out2, need2);
        assertEquals(out3, need3);
    }

    @org.junit.Test
    public void find() {
        List list = new List();

        list.addBack(1);
        list.addBack("Tet");
        int out1 = list.find("Tet");
        int out2 = list.find(2);

        assertEquals(out1, 1);
        assertEquals(out2, 0);
    }

    @org.junit.Test
    public void isEmpty() {
        List list = new List();

        list.addBack(1);
        int out1 = list.isEmpty();
        list.erase(1);
        int out2 = list.isEmpty();

        assertEquals(out1, 0);
        assertEquals(out2, 1);
    }

    @org.junit.Test
    public void get() {
        List list = new List();

        list.addBack(1);
        list.addBack("Tet");

        Object out1 = list.get(2);
        String need1 = "Tet";

        list.get(3);
        Object out2 = list.get(3);
        Object need2 = null;

        assertEquals(out1, need1);
        assertEquals(out2, need2);
    }

    @org.junit.Test
    public void insert() {
        List list = new List();

        list.addBack(1);
        list.addBack("Tet");

        list.insert("Niew", 2);
        String out1 = list.toString();
        list.insert(4, 4);
        String out2 = list.toString();

        String need1 = "[1, Niew, Tet]";
        String need2 = "[1, Niew, Tet, 4]";

        assertEquals(out1, need1);
        assertEquals(out2, need2);

    }
}