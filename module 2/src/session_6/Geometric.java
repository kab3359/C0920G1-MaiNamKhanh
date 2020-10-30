package session_6;

public class Geometric {
    private String color = "white";
    private boolean filled = false;

    /* các khởi tạo tử */
    public Geometric() {
    }

    public Geometric(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /* các thuộc tính */
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return "created with \"" + color + "\" color and " +
                (filled == false ? "no fill" : "filled with \"" + filled + "\" color");
    }
}
