package encapsulation;

public class Calculator {
	
	private double firstOperand;
	private double secondOperand;
	private char operator;
	
	public void setFirstOperand(double firstValue) {
		this.firstOperand = firstValue;
	}
	
	public void setSecondOperand(double secondValue) {
		this.secondOperand = secondValue;
	}
	
	public void setOperator(char userOperator) {
		this.operator = userOperator;
	}
	
	public double calculateResult() {
		switch(getOperator())  {
		case '-' : return getFirstOperand() - getSecondOperand();
		case '+' : return getFirstOperand() + getSecondOperand();
		case '/' : if (getSecondOperand() != 0) {
			return (getFirstOperand() / getSecondOperand());
		}else{
			return 0;
		}
		case '*' : return getFirstOperand()*getSecondOperand();
		case '%' : return getFirstOperand()%getSecondOperand();
		default: return 0;
		}
		
	}

	public double getSecondOperand() {
		return secondOperand;
	}

	public double getFirstOperand() {
		return firstOperand;
	}

	public char getOperator() {
		return operator;
	}

}
