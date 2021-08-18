import java.util.Arrays;

public class MyList<E> {
    private static final int DEFAULT_CAPACITY = 10; //default array's length
    public static final String INDEX_OUT_OF_BOUNDS_EXCEPTION = "Index out of bounds exception!";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION = "Illegal Argument Exception!";

    private int size = 0;
    private Object[] elementData; // property? Must be "Object" because we can not initialize an E object directly!!!

    //constructors
    public MyList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        elementData = new Object[initialCapacity];
    }

    public void ensureCapacity() {
        elementData = Arrays.copyOf(elementData, elementData.length * 2);
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity < size) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION);
        }
        elementData = Arrays.copyOf(elementData, minCapacity);
    }

    public int size() {
        return this.size;
    }

    public boolean isFull() {
        return size == elementData.length;
    }

    public void add(int index, E element) { // add an element to the end of the array
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS_EXCEPTION);
        }
        if (isFull()) {
            ensureCapacity();
        }
        Object[] newElementData = new Object[elementData.length];
        System.arraycopy(elementData, 0, newElementData, 0, index);
        System.arraycopy(elementData, index, newElementData, index + 1, size - index);
        newElementData[index] = element;
        elementData = newElementData;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS_EXCEPTION);
        }
        Object removedElement = elementData[index];
        elementData[index] = null;
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size--] = null;
        return (E) removedElement;
    }

    public E clone() {
        Object[] newElementData = Arrays.copyOf(elementData, elementData.length);
        return (E) newElementData;
    }


    public boolean contain(E object) {
        return indexOf(object) >= 0;
    }

    public int indexOf(E object) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E object) {
        elementData[size++] = object;
        return true;
    }

    public E get(int index){
        if (index < 0 || index > size -1) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS_EXCEPTION);
        }
        return (E) elementData[index];
    }

    public void clear(){
        for (Object elementData : elementData) {
            elementData = null;
        }
        size = 0;
    }

}