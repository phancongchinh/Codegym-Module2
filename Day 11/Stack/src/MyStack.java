import java.util.Arrays;

public class MyStack {
    private int[] integers;
    private int size;
    private int index = 0;

    public MyStack(int size){
        this.size = size;
        this.integers = new int[size];
    }

    public void ensureCapacity(){
        if (index == size){
            int newSize = this.size * 2;
            integers = Arrays.copyOf(integers, newSize);
        }
    }

    public void push(int integer){
        if(index == size){
            ensureCapacity();
        }
        integers[index++] = integer;
    }

    public int pop(){
        if (index < 0) {
            return -1;
        } else {
            return integers[--index];
        }
    }

    public int[] getIntegers(){
        return integers;
    }
}
