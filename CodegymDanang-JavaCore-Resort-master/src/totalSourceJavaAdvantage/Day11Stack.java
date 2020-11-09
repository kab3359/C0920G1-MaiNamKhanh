package totalSourceJavaAdvantage;

import java.util.Scanner;
import java.util.Stack;

public class Day11Stack {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------Day 11: Stack -----------------");
		Stack<EmployeesProfile> stackEmployeeProfile = new Stack<>();
		EmployeesProfile employeesProfile01 = new EmployeesProfile("Quang Tuan 1");
		EmployeesProfile employeesProfile02 = new EmployeesProfile("Quang Tuan 2");
		EmployeesProfile employeesProfile03 = new EmployeesProfile("Quang Tuan 3");
		showPush(stackEmployeeProfile, employeesProfile01);
		showPush(stackEmployeeProfile, employeesProfile02);
		showPush(stackEmployeeProfile, employeesProfile03);
		String resultSearchStack = scanner.nextLine();
		printStack(stackEmployeeProfile, resultSearchStack);
	}
	
	public static void printStack(Stack<EmployeesProfile> stackEmployeeProfile, String resultSearchStack) {
		while (!stackEmployeeProfile.empty()) {
			String nameElement = stackEmployeeProfile.pop().toString();
			if (nameElement.equals(resultSearchStack)) {
				System.out.println(resultSearchStack+" exited.");
			}
		}
	}
	
	public static void  showPush(Stack stackName, EmployeesProfile nameEmployee) {
		stackName.push(nameEmployee);
	}

}
