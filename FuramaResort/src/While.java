import java.io.File;
import java.util.LinkedList;

public class While {
//    public static void main(String[] args) {
//        File dir = new File("dir");
//        File f = new File(dir, "f");
//    }
    int value;
    While(int value){
        this.value = value;
    }
    public String toString(){
        return "value =" + this.value;
    }
    public static void main(String[] args) {
       While d1 = new While(1);
       While d2 = new While(2);
       swap(d1, d2);
        System.out.println(d1 + "," + d2);
        int a = 1;
        int b = 2;
        swap1(a, b);
        System.out.println(a + "," + b);
    }
    static void swap(While d1, While d2){
        While temp = d1;
        d1 = d2;
        d2 = temp;
    }
    static void swap1(int d1, int d2){
        int temp = d1;
        d1 = d2;
        d2 = temp;
    }
}
