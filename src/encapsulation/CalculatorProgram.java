package encapsulation;

import java.util.Scanner;

public class CalculatorProgram {
	
	public static void main (String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Første tall: ");
		double firstInput = scanner.nextDouble();
		System.out.println("Hvilken operasjon vil du gjøre? ");
		char operandInput = scanner.next().charAt(0);
		System.out.println("Andre tall: ");
		double secondInput = scanner.nextDouble();
		
		Calculator calculator = new Calculator();
		calculator.setFirstOperand(firstInput);
		calculator.setOperator(operandInput);
		calculator.setSecondOperand(secondInput);
		
		System.out.println("= " + calculator.calculateResult());
		
		
	}

}
