public class Stack<T> {

    private static class Node<T> {
        private final T value;
        private final Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T obj) {
        top = new Node<>(obj, top);
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("pop() on an empty stack");
        }
        T value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("top() on an empty stack");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("bottom [");
        Node<T> current = top;
        java.util.List<T> values = new java.util.ArrayList<>();
        while (current != null) {
            values.add(current.value);
            current = current.next;
        }
        for (int i = values.size() - 1; i >= 0; i--) {
            sb.append(values.get(i));
            if (i > 0) {
                sb.append(", ");
            }
        }
        return sb.append("] top").toString();
    }
}
