package session_6;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        a.p(10);
        a.p(10.0);
    }
}
class A extends B {
    @Override
    public void p(double number) {
        System.out.println(number);
    }
}

class B {
    public void p(double number) {
        System.out.println(number * 2);
    }
}
