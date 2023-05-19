
// This program is the custom implementation of stack from scratch
// This Custom stack is not dynamic and have following methods:
// 1.Push
// 2.Pop
// 3.isEmpty
// 4.isFull
// 5.peek
// 6.search

public class CustomStack {

    // Data variables
    protected int[] data;
    private static final int DEF_SIZE = 10;
    private int ptr = -1;

    // Constructor without parameters
    CustomStack(){
        data = new int[DEF_SIZE];
    }
    CustomStack(int size){
        data = new int[size];
    }


    // Method to push an element if stack is not full
    public boolean push(int ele) throws Exception{
        if(isFull()){
            throw new Exception("Stack is Full");
        }
        ptr++;
        data[ptr] = ele;
        return true;
    }


    // Method to pop and element if stack is not empty
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty!");
        }
        return data[ptr--];
    }

    // Method to get the top element(peek) of the stack
    public int peek() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is empty!");
        return data[ptr];
    }

    // Method to search element in the stack
    public boolean search(int ele) throws Exception{
        if(isEmpty())
            throw new Exception("Stack is empty!");

        for(int i = 0; i <= ptr; i++){
            if(data[i] == ele)
                return true;
        }
        return false;
    }



    // Method to check if stack is empty
    public boolean isEmpty(){
        return ptr == -1;
    }


    // Method to check if the stack is full
    public boolean isFull(){
        return ptr == data.length - 1;
    }

}
