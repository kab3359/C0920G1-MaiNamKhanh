package session_4.bai_tap;

public class Fan {

    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;
    private static int speed = SLOW;
    private static boolean on = false;
    private static double radius = 5;
    private static String color = "blue";

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public static int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public static boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public static double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public Fan(){
    }
    public String toString(){
        if(Fan.isOn()){
            return "speed: " + Fan.getSpeed() + " color: " + Fan.getColor() + " radius: " + Fan.getRadius() + " Fan is on";
        }else {
            return "color: " + Fan.getColor() + " radius: " + Fan.getRadius() + " Fan is off";
        }
    }
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeed(FAST);
        fan1.setRadius(10.0);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());
        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5.0);
        fan2.setColor("blue");
        fan2.setOn(false);
        System.out.println(fan2.toString());
    }
}
