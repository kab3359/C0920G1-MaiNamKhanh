package session_15.bai_tap.IllegalTriangleException;

public class IllegalTriangleException extends Exception {

    public IllegalTriangleException(double side) {
        super(side + " is larger than other two combined");
    }

}
