package refactoring;

public class Calculate {

	// Instance Variables
	private ArrayList<Character> _oStack;
	private ArrayList<Double> _vStack;
	private char[] _infix;
	private char[] _postfix;

	// Constructor
	public Calculate() {
		this._oStack = new ArrayList<Character>();
		this._vStack = new ArrayList<Double>();
	}

	// Private Methods
	private boolean isDigit(char aToken) {
		if (aToken >= '0' && aToken <= '9') {
			return true; 
		}
		else {
			return false;
		}
	}
	private int inComingPrecedence(char aToken) {
		switch(aToken) {
		case '(':
			return 20;
		case ')':
			return 19;
		case '^':
			return 17;
		case '*': case '/': case '%':
			return 13;
		case '+': case '-':
			return 12;
		case '$':
			return 0;
		default:
			return -1;
		}
	}
	private int inStackPrecedence(char aToken) {
		switch(aToken) {
		case '(':
			return 0;
		case ')':
			return 19;
		case '^':
			return 16;
		case '*': case '/': case '%':
			return 13;
		case '+': case '-':
			return 12;
		case '$':
			return 0;
		default:
			return -1;
		}
	}
	private void showOStack() {
		int size = this._oStack.size();
		String show = "OStack : ";
		for (int i = 0; i < size; i++) {
			show += this._oStack.elementAt(i) + " ";
		}
		System.out.println(show);
	}
	private void showVStack() {
		int size = this._vStack.size();
		String show = "VStack : ";
		for (int i = 0; i < size; i++) {
			show += this._vStack.elementAt(i) + " ";
		}
		System.out.println(show);
	}

	// Public Methods
	public String postfix() {
		String postfix = "";
		int size = this._postfix.length;
		for (int i = 0; i < size; i++) {
			postfix += this._postfix[i];
		}
		return postfix;
	}

	public void setInfix(String inputInfix) {
		this._infix = inputInfix.toCharArray();
	}
	
	public boolean infix2Postfix() {
		int i = 0; // pointer for infix
		int p = 0; // pointer for postfix
		char currentToken, popToken, topToken;
		
		int infixSize = this._infix.length;
		this._postfix = new char[infixSize];
		
		while (i < infixSize) {
			currentToken = this._infix[i++];
			if (this.isDigit(currentToken)) {
				this._postfix[p++] = currentToken;
			}
			else {
				if (currentToken == ')') {
					if (!this._oStack.isEmpty()) {
						popToken = (char)this._oStack.pop();
					}
					else {	return false;	}
					while (popToken != '(') {
						this._postfix[p++] = popToken;
						if (!this._oStack.isEmpty()) {
							popToken = (char)this._oStack.pop(); 
						}
						else {	return false;	}
					}
				}
				else {
					int incomingP = this.inComingPrecedence(currentToken);
					if (!this._oStack.isEmpty()) {
						topToken = (char)this._oStack.peek();
						while (this.inStackPrecedence(topToken) >= incomingP) {
							popToken = this._oStack.pop();
							this._postfix[p++] = popToken;
							if (!this._oStack.isEmpty()) {
								topToken = (char)this._oStack.peek();
							}
							else {	break;	}
						}
					}
					this._oStack.push(currentToken);
				}
				this.showOStack();
			}
		}
		while (!this._oStack.isEmpty()) {
			popToken = this._oStack.pop();
			this._postfix[p++] = popToken;
		}
		char[] temp = this._postfix;
		this._postfix = new char[p];
		System.arraycopy(temp, 0, this._postfix, 0, p);
		return true;
	}

	public double evalPostfix() {
		int postfixSize = this._postfix.length;
		int p = 0;
		double frontToken, backToken;
		char currentToken;
		while (p < postfixSize) {
			currentToken = this._postfix[p++]; 
			if (this.isDigit(currentToken)) {
				this._vStack.push(Double.parseDouble("" + currentToken));
			}
			else {
				backToken = this._vStack.pop();
				frontToken = this._vStack.pop();
				if (currentToken == '+') {
					this._vStack.push(frontToken + backToken); 
				}
				else if (currentToken == '-') {
					this._vStack.push(frontToken - backToken); 
				}
				else if (currentToken == '*') {
					this._vStack.push(frontToken * backToken); 
				}
				else if (currentToken == '/') {
					this._vStack.push(frontToken / backToken); 
				}
				else if (currentToken == '%') {
					this._vStack.push(frontToken % backToken); 
				}
				else if (currentToken == '^') {
					this._vStack.push(Math.pow(frontToken, backToken)); 
				}
			}
			this.showVStack();
		}
		return this._vStack.pop();
	}

}