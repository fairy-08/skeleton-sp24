import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private T[] items;
    private int size;
    private int front;
    private int rear;

    public ArrayDeque61B() {
        items = (T[]) new Object[8];
        size = 0;
        front = 0;
        rear = 0;
    }

    private void expansion() {
        T[] newItems = (T[]) new Object[items.length * 2];
        for (int i = 0; i < size; i++) {
            newItems[i] = get(i);
        }
        front = 0;
        rear = size;
        items = newItems;
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            expansion();
        }
        front = Math.floorMod(front - 1, items.length);
        items[front] = x;
        size++;
    }

    @Override
    public void addLast(T x) {
        if (size == items.length) {
            expansion();
        }
        items[rear] = x;
        rear = Math.floorMod(rear + 1, items.length);
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            returnList.addLast(get(i));
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removed = items[front];
        items[front] = null;
        front = Math.floorMod(front + 1, items.length);
        size--;
        return removed;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        rear = Math.floorMod(rear - 1, items.length);
        T removed = items[rear];
        items[rear] = null;
        size--;
        return removed;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int i = Math.floorMod(front + index, items.length);
        return items[i];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

}
