package session_10.test;

public class Test1 {
    public static void main(String[] args) {
        Node<String> head = null;
        Node<String> tail = null;
        head = new Node<>("Chicago");
        tail = head;
        tail.next = new Node<>("Denver");
        tail = tail.next;
        tail.next = new Node<>("Dallas");
        tail = tail.next;
        //Duyệt mảng
        Node current = head;
        while(current != null){
            System.out.println(current.element);
            current = current.next;
        }
    }
}
