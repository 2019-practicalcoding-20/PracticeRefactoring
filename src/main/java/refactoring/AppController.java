package refactoring;

public class AppController {

	// Instance Variables
	private AppView _appView;
	private Calculate _calcualte;

	// Constructor
	public AppController() {
		this._appView = new AppView();
		this._calcualte = new Calculate();
	}

	// Private Methods
	private void showMessage(MessageID aMessageID) {
		switch(aMessageID) {
		case Notice_StartProgram:
			this._appView.outputMessage(":: 프로그램을 시작합니다. ::\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage(":: 프로그램을 종료합니다. ::\n");
			break;
		case Notice_StartMenu:
			this._appView.outputMessage("[수식 입력을 시작합니다.]\n");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("[수식 입력을 종료합니다.]\n");
			break;
		case Show_Infix2Postfix:
			this._appView.outputMessage("[Infix를 Postfix로]\n");
			break;
		case Error_WrongInput:
			this._appView.outputMessage("<<< 잘못된 수식입니다. >>>\n");
			break;
		default:
			break;
		}
	}
	private void evalExpression() {
		double finalValue;
		this.showMessage(MessageID.Show_Infix2Postfix);
		
		if (this._calcualte.infix2Postfix()) {
			this._appView.outputPostfix(this._calcualte.postfix());
			finalValue = this._calcualte.evalPostfix();
			this._appView.outputResult(finalValue);
		}
		else {
			this.showMessage(MessageID.Error_WrongInput);
		}
	}

	// Public Methods
	public void run() {
		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_StartMenu);
		
		String input = this._appView.inputExpression();
		while (input.charAt(0) != '!') {
			this._calcualte.setInfix(input);
			this.evalExpression();
			input = this._appView.inputExpression();
		}
		
		this.showMessage(MessageID.Notice_EndMenu);
		this.showMessage(MessageID.Notice_EndProgram);
	}

}