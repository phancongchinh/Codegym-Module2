import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elementData; // property? Must be "Object" because we can not initialize an E object directly!!!

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        elementData = new Object[initialCapacity];
    }

    public void ensureCapacity() {
        Object[] newElementsData = new Object[elementData.length * 2];
        System.arraycopy(elementData, 0, newElementsData, 0, elementData.length);
        elementData = newElementsData;
    }

    public void add(int index, E element) {
        if (size == elementData.length) {
            ensureCapacity();
        }
        Object[] newElementData = new Object[elementData.length + 1];
        System.arraycopy(elementData, 0, newElementData, 0, index);
        System.arraycopy(elementData, index, newElementData, index + 1, elementData.length - index);
        newElementData[index] = element;
        elementData = newElementData;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index > elementData.length - 1) {
            throw new IndexOutOfBoundsException("Index out of bounds exception!");
        }
        Object oldValue = elementData[index];
        Object[] newElementData = new Object[elementData.length - 1];
        System.arraycopy(elementData, 0, newElementData, 0, index);
        System.arraycopy(elementData, index + 1, newElementData, index, elementData.length - index);
        elementData = newElementData;
        size--;
        return (E) oldValue;
    }

    public int size() {
        return elementData.length;
    }

    public E clone() {
        Object newArrayList = new Object[elementData.length];
        Arrays.copyOf(elementData, elementData.length);
        return (E) newArrayList;
    }

    public boolean contain(E object) {
        for (Object element : elementData) {
            if (object.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E object) {
        int index = -1;
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(object)) {
                index = i;
            }
        }
        return index;
    }

    public boolean add(E object) {
        return contain(object) ?;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public void clear() {
        for (Object element : elementData) {
            element = null;
        }
    }
}