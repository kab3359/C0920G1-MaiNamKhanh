package session_11.bai_tap.trien_khai_queue_su_dung_danh_sach_lien_ket_vong;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.add(15);
        queue.add(18);
        System.out.println(queue.toString());
        queue.remove();
        System.out.println(queue.toString());
        System.out.println(queue.size());
        queue.add(18);
        queue.add(19);
        queue.add(20);
        queue.add(21);
        queue.add(22);
        System.out.println(queue.toString());
        queue.remove();
        System.out.println(queue.toString());

    }
}
