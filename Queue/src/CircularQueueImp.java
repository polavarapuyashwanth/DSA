
// Program to implement the circular queue custom class

public class CircularQueueImp {
    public static void main(String[] args)throws Exception {
        CircularQueue queue = new CircularQueue(5);
        System.out.println(queue.isEmpty());
        queue.display();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.display();
        queue.delete();
        queue.delete();
        queue.insert(6);
        queue.insert(7);
        //queue.insert(8);
        queue.display();
    }
}
