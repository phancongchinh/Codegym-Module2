public class MyStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.push(3);
        myStack.push(4);
        myStack.push(2);
        myStack.push(2);
        myStack.push(2);
        myStack.push(2);
        myStack.push(1);
        for (int x : myStack.getIntegers()) {
            System.out.println(x);
        }
        System.out.println("pop");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        for (int x : myStack.getIntegers()) {
            System.out.println(x);
        }
    }
}