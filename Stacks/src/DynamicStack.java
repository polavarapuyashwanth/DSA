
// Similar to stack but dynamic in nature
// Which means the size of the stack is not fixed.
// We can push any number of elements

public class DynamicStack extends CustomStack {
    DynamicStack(){
        super();
    }
    DynamicStack(int size){
        super(size);
    }

    // Only method different from Normal stack is push

    @Override
   public boolean push(int ele) throws Exception{
        if(isFull()){
            int[] temp = new int[2 * data.length];
            for(int i = 0; i < data.length; i++)
                temp[i] = data[i];

            data = temp;
        }
        return super.push(ele);
    }

}
