package session_4.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation (double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    public double getDiscriminant(){
        return this.b * this.b - 4 * this.a * this.c;
    }
    public double getRoot1(){
            return (-this.b + Math.pow(this.getDiscriminant(), 0.5)) / 2 * this.a;
    }
    public double getRoot2(){
            return (-this.b - Math.pow(this.getDiscriminant(), 0.5)) / 2 * this.a;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập a");
        double a = input.nextDouble();
        System.out.println("nhập b");
        double b = input.nextDouble();
        System.out.println("nhập c");
        double c = input.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println("Discriminant is: " + quadraticEquation.getDiscriminant());
        if (quadraticEquation.getDiscriminant() == 0){
            System.out.println("phương trình có nghiệm: " + quadraticEquation.getRoot1());
        }else if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("phương trình có 2 nghiệm: " + quadraticEquation.getRoot1() + " và " + quadraticEquation.getRoot2());
        }else {
            System.out.println("phương trình vô nghiệm");
        }
    }
}
