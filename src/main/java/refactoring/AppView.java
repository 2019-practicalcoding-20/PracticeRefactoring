package refactoring;

import java.util.Scanner;

public class AppView {
	
	// Instance Variable
	private Scanner _scanner;
	
	// Constructor
	public AppView() {
		this._scanner = new Scanner(System.in);
	}
	
	// Public Methods
	public String inputString() {
		return this._scanner.next();
	}
	public String inputExpression() {
		System.out.print("> 수식을 입력하세요: ");
		return this.inputString();
	}
	public void outputPostfix(String postfix) {
		int postfixSize = postfix.length();
		String outputPostfix = "\n[Postfix] ";
		for (int i = 0; i < postfixSize; i++) {
			outputPostfix += postfix.charAt(i) + " ";
		}
		System.out.println(outputPostfix);
	}
	public void outputResult(double result) {
		System.out.println("\n[최종값] " + result + "\n");
	}
	public void outputMessage(String aString) {
		System.out.print(aString);
	}

}
