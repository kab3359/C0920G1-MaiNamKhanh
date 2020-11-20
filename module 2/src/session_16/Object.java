package session_16;

public class Object {
    private int a;
    private String b;
    private String c;

    public Object(int a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Object{");
        sb.append("a=").append(a);
        sb.append(", b='").append(b).append('\'');
        sb.append(", c='").append(c).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
