package session_10.thuc_hanh.trien_khai_lop_list_don_gian;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(8);
        listInteger.add(6);
        listInteger.add(6);
        listInteger.add(10);

        System.out.println("element 4: "+listInteger.get(4));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));

        listInteger.get(6);
        System.out.println("element -1: " + listInteger.get(6));
    }
}
