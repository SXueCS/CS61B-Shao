import java.util.List;

/**
 * Achieve a Deque using array based list
 */
/* Invariants:
    nextFirst: The position of the next first item should be when adding items.
    nextLast: The position of the next last item should be when adding items.
    size: The number of items in the Deque.
    FACTOR: The factor used when resizing the Array.
    INITIAL_ROOM: The initial room of the array when creating the Deque for the first time: 8

    AList(): Creates a empty array.
    size(): Return the size of the Deque.
    printList(): Print the Deque to the screen.
    move(int index, int movement): Change the index with a given movement.
    addFirst(int item): Add a item to the head of the Deque.
    addLast(int item):Add a item to the tail of the Deque.
    get(int index): Get the ith item of the Deque.
    removeFirst(): Remove the head of the Deque, return its value.
    removeLast(): Remove the tail of the Deque, return its value.
    larger(items.length * FACTOR): Enlarge the array when its totally full, size == items.length
    shrink(items.length / FACTOR): Half the array when the number of items is smaller than length / 4
    reSizeHelper(int newroom): resize the array
 */

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private final int FACTOR = 2;
    private final int INITIAL_ROOM = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_ROOM];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public int size() {
        return size;
    }

    //For the ArrayList based Deque, we only add or remove one item at once.
    //From a more general aspect, we 'd better get the Mod of the index, plus/minus array.length
/*    private int addOne(int position) {
        position = position + 1 & items.length - 1;
        return position;
    }
    private int minusOne(int position) {
        position = position - 1 & items.length - 1;
        return position;
    }*/
    private int move(int index, int movement) {
        index = index + movement & items.length - 1;
        return index;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = move(nextFirst, -1);
        size++;
        reSize();
    }
    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = move(nextLast, 1);
        size++;
        reSize();
    }
    public T get(int index) {
        return items[index];
    }

    public T removeFirst() {
        T res = items[move(nextFirst, 1)];
        items[move(nextFirst, 1)] = null;
        nextFirst = move(nextFirst, 1);
        size--;
        reSize();
        return res;
    }
    public T removeLast() {
        T res = items[move(nextLast, -1)];
        items[move(nextLast, -1)] = null;
        nextLast = move(nextLast, -1);
        size--;
        reSize();
        return res;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (int index = move(nextFirst, + 1); index != move(nextLast, -1); index = move(index, 1)) {
            System.out.print(items[index] + " ");
        }
        System.out.println(items[move(nextLast, -1)]);
    }
    //Modify the size of array.
    private void reSize() {
        if (size == items.length) {
            larger();
        } else if (size < items.length / 4 && items.length != INITIAL_ROOM) {
            shrink();
        }
    }
    private void larger() {
        reSizeHelper(items.length * FACTOR);
    }
    private void shrink() {
        reSizeHelper(items.length / FACTOR);
    }

    /*The reSizeHelper create a new array, and copy items from the old one.
     * The method depends on two circumstances, front < back and front > back
     * If the deque is sequential, we just copy the array for once, size items.
     * If the deque is separated, we copy it twice, one items.length - front, one back + 1
     */
    private void reSizeHelper(int newroom) {
        T[] a = (T[]) new Object[newroom];
        int front = move(nextFirst, 1);
        int back = move(nextLast, -1);
        if (back < front) {
            System.arraycopy(items, front, a, 0, items.length - front);
            System.arraycopy(items, 0, a, items.length - front, back + 1);
        } else {
            System.arraycopy(items, front, a, 0, size);
        }
        nextFirst = newroom - 1;
        nextLast = size;
        items = a;
    }
}