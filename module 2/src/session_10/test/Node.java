package session_10.test;

class Node<E> {
    E element;
    Node<E> next;
    int size = 0;
    Node<String> head = null;
    Node<String> tail = null;

    public Node(E e) {
        element = e;
    }

    public void addFirst(E e){
        Node newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null)
            tail = head;
    }

    public void addLast(E e) {
        Node newNode = new Node<>(e);

        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }

        size++;
    }

    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node temp = current.next;
            current.next = new Node(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) return null;
        else {
            Node temp = head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return (E) temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) return null; // Nothing to remove
        else if (size == 1) { // Only one element in the list
            Node temp = head;
            head = tail = null; // list becomes empty
            size = 0;
            return (E) temp.element;
        } else {
            Node current = head;

            for (int i = 0; i < size - 2; i++)
                current = current.next;

            Node temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return (E) temp.element;
        }
    }
    public E remove(int index) {
        if (index < 0 || index >= size) return null; // Out of range
        else if (index == 0) return removeFirst(); // Remove first
        else if (index == size - 1) return removeLast(); // Remove last
        else {
            Node previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node current = previous.next;
            previous.next = current.next;
            size--;
            return (E) current.element;
        }
    }
}
