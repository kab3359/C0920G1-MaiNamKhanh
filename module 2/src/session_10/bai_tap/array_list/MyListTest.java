package session_10.bai_tap.array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add(0,"Khánh");
        list.add(1,"Tùng");
        list.add(2,"Long");
        list.add(3,"Quy");
        list.add(4,"Phung");
        System.out.println(list.toString());
        MyList<Integer> list1 = new MyList<>(20);
        System.out.println(list1.toString());
        list1.add(1,5);
        System.out.println(list1.toString());

    }
}
