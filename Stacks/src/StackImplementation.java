
// Program to implement Custom stack

public class StackImplementation {
    public static void main(String[] args) throws  Exception{
        DynamicStack stack = new DynamicStack(2);

        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(9);
        stack.push(9);
        stack.push(9);
        stack.push(9);
        stack.push(10);
        System.out.println(stack.pop());
        System.out.println(stack.search(1));
    }
}
