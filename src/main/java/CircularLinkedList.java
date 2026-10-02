public class CircularLinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = this;
        }
    }

    private final Node<T> dummy;

    public CircularLinkedList() {
        dummy = new Node<>(null);
        dummy.next = dummy;
    }

    public void addItem(T item) {
        Node<T> newNode = new Node<>(item);

        Node<T> current = dummy;

        while (current.next != dummy) {
            current = current.next;
        }

        newNode.next = dummy;
        current.next = newNode;
    }

    public void showList() {
        Node<T> current = dummy.next;

        while (current != dummy) {
            System.out.print(current.value + " ");
            current = current.next;
        }

        System.out.println();
    }

    public void showReverseList() {
        showReverseListRecursive(dummy.next);
        System.out.println();
    }

    private void showReverseListRecursive(Node<T> current) {
        if (current == dummy) {
            return;
        }

        showReverseListRecursive(current.next);

        System.out.print(current.value + " ");
    }

    public boolean find(T item) {
        Node<T> current = dummy.next;

        while (current != dummy) {
            if (java.util.Objects.equals(current.value, item)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean remove(T item) {
        Node<T> previous = dummy;
        Node<T> current = dummy.next;

        while (current != dummy) {
            if (java.util.Objects.equals(current.value, item)) {
                previous.next = current.next;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }
}
