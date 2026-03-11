package core.basesyntax;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;
    public ArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    @Override
    public void add(T value) {
        if (elements.length == size) {
            int newSize = (int) (size * 1.5);
            elements = Arrays.copyOf(elements, newSize);
        }
        elements[size] = value;
        size++;
    }
    @Override
    public void add(T value, int index) {
        if (index < 0 || index > size)
            throw new ArrayListIndexOutOfBoundsException("Invalid index: " + index);
        if (elements.length == size) {
            int newSize = (int) (size * 1.5);
            elements = Arrays.copyOf(elements, newSize);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
        size++;
    }
    @Override
    public void addAll(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }
    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayListIndexOutOfBoundsException("Invalid index: " + index);
        return elements[index];
    }
    @Override
    public void set(T value, int index) {
        if (index < 0 || index >= size)
            throw new ArrayListIndexOutOfBoundsException("Invalid index: " + index);
        elements[index] = value;
    }
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new ArrayListIndexOutOfBoundsException("Invalid index: " + index);
        T removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removedElement;
    }
    @Override
    public T remove(T element) {
        T removedElement = element;
        for (int i = 0; i < size; i++) {
                if (Objects.equals(elements[i], element)) {
                    remove(i);
                    return removedElement;
                }
            }
        throw new NoSuchElementException("Element not found");
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
       return size == 0;
    }
}
