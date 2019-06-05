public interface Deque<T> {
    void addFirst(T x);
    void addLast(T x);
    T removeFirst();
    T removeLast();
    boolean isEmpty();
    int size();
    void printDeque();
    T get(int x);
}
