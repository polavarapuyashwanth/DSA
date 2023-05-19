
// This program is to implement Circular Queue from scratch
// The following are the methods or operations on circular queues.
// 1.insert() - from back or rear
// 2.delete  - from front
// 3.isEmpty()
// 4.isFull()
// 5.display()
// 6.peek (from front or first element)

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE= 10;
    int frnt = -1;
    int end = -1;
    int list_size = 0;

    // Constructors
    CircularQueue(){
        this.data = new int[DEFAULT_SIZE];
    }

    CircularQueue(int size){
        data = new int[size];
    }


    // Method to insert into circular queue
    public boolean insert(int ele) throws Exception{
        if(isFull()){
            throw new Exception("Queue is Full!");
        }

        if(frnt == -1)
            frnt = 0;
        end = (end + 1) % data.length;
        data[end] = ele;
        return true;
    }

    // Method to delete the element from Queue
    public int delete() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty!");
        }
        int removed = data[frnt];
        if(frnt == end){ // We know only one element is present
            frnt = -1;
            end = -1;
        }
        else {
            frnt = (frnt + 1) % data.length;
        }
        return removed;
    }

    // Method to display elements in queue
    public void display(){
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        int i = frnt;

        do{
            System.out.println(data[i] + " ");
            i = (i + 1) % data.length;
        }while(i != end);
        System.out.println(data[i] + "------>End");
    }

    // Method to check if queue is empty or not
    public boolean isEmpty(){
        if(frnt == -1)
            return true;
        return false;
    }

    // Method to check if Queue is full
    public boolean isFull(){
        if(frnt == 0 && end == data.length - 1 || frnt == end + 1)
            return true;
        return false;
    }

}
