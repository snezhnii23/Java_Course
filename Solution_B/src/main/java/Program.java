public class Program {

    public static void main(String[] args)
    {
       /* List list = new List();
        list.addBack(6);
        list.print();
        list.addBack("Tet");
        list.print();
        list.addBack(1.0754);
        list.print();
        list.erase(2);
        list.print();
        System.out.println(list.find(6));
        System.out.println(list.insert("Elo", 2));
        list.print();
        list.erase(1);
        list.print();
        list.erase(3);
        list.print();
        list.erase(2);
        list.print();
        list.erase(1);
        list.print();
        System.out.println(list.isEmpty());*/

        Queue queue = new Queue();
        queue.push(1);
        queue.print();
        queue.push("Tet");
        queue.print();
        queue.erase();
        queue.print();
        queue.erase();
        queue.print();
        System.out.println(queue.isEmpty());
    }
}
