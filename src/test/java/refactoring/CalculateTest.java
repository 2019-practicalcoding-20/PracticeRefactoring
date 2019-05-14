package refactoring;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {
	Calculate _calc;
	@Test
	public void infix2Postfix_덧셈() {
		this._calc = new Calculate();
		this._calc.setInfix("1+1");
		this._calc.infix2Postfix();
		assertEquals("11+", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_뺄셈() {
		this._calc = new Calculate();
		this._calc.setInfix("1-1");
		this._calc.infix2Postfix();
		assertEquals("11-", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_곱셈() {
		this._calc = new Calculate();
		this._calc.setInfix("1*1");
		this._calc.infix2Postfix();
		assertEquals("11*", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_나눗셈() {
		this._calc = new Calculate();
		this._calc.setInfix("1/1");
		this._calc.infix2Postfix();
		assertEquals("11/", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_모듈러() {
		this._calc = new Calculate();
		this._calc.setInfix("1%1");
		this._calc.infix2Postfix();
		assertEquals("11%", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_제곱() {
		this._calc = new Calculate();
		this._calc.setInfix("1^1");
		this._calc.infix2Postfix();
		assertEquals("11^", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_연산순서_덧셈_곱셈() {
		this._calc = new Calculate();
		this._calc.setInfix("1+2*3");
		this._calc.infix2Postfix();
		assertEquals("123*+", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_연산순서_덧셈_곱셈_제곱() {
		this._calc = new Calculate();
		this._calc.setInfix("1+2*3^4");
		this._calc.infix2Postfix();
		assertEquals("1234^*+", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_연산순서_뺄셈_나눗셈() {
		this._calc = new Calculate();
		this._calc.setInfix("1-2/3");
		this._calc.infix2Postfix();
		assertEquals("123/-", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_연산순서_괄호_덧셈_곱셈() {
		this._calc = new Calculate();
		this._calc.setInfix("(1+2)*3");
		this._calc.infix2Postfix();
		assertEquals("12+3*", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_연산순서_괄호_뺄셈_나눗셈() {
		this._calc = new Calculate();
		this._calc.setInfix("(1-2)/3");
		this._calc.infix2Postfix();
		assertEquals("12-3/", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_큰숫자() {
		this._calc = new Calculate();
		this._calc.setInfix("1-2/3+125123415123415123415134");
		this._calc.infix2Postfix();
		assertEquals("123/-125123415123415123415134+", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_큰숫자_여러개() {
		this._calc = new Calculate();
		this._calc.setInfix("1849723845792-2834793475/323523457568687+125123415123415123415134");
		this._calc.infix2Postfix();
		assertEquals("18497238457922834793475323523457568687/-125123415123415123415134+", this._calc.postfix());
	}
	
	
	
	@Test
	public void evalPostfix_덧셈() {
		this._calc = new Calculate();
		this._calc.setInfix("1+1");
		this._calc.infix2Postfix();
		assertEquals("2.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_뺄셈() {
		this._calc = new Calculate();
		this._calc.setInfix("1-1");
		this._calc.infix2Postfix();
		assertEquals("0.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_곱셈() {
		this._calc = new Calculate();
		this._calc.setInfix("8*4");
		this._calc.infix2Postfix();
		assertEquals("32.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_나눗셈_정수결과() {
		this._calc = new Calculate();
		this._calc.setInfix("8/4");
		this._calc.infix2Postfix();
		assertEquals("2.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_나눗셈_소수결과() {
		this._calc = new Calculate();
		this._calc.setInfix("4/8");
		this._calc.infix2Postfix();
		assertEquals("0.5", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_모듈러() {
		this._calc = new Calculate();
		this._calc.setInfix("9%4");
		this._calc.infix2Postfix();
		assertEquals("1.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_제곱() {
		this._calc = new Calculate();
		this._calc.setInfix("2^5");
		this._calc.infix2Postfix();
		assertEquals("32.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_연산순서_덧셈_곱셈() {
		this._calc = new Calculate();
		this._calc.setInfix("1+2*3");
		this._calc.infix2Postfix();
		assertEquals("7.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_연산순서_뺄셈_나눗셈() {
		this._calc = new Calculate();
		this._calc.setInfix("3-9/3");
		this._calc.infix2Postfix();
		assertEquals("0.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_연산순서_괄호_덧셈_곱셈() {
		this._calc = new Calculate();
		this._calc.setInfix("(1+2)*3");
		this._calc.infix2Postfix();
		assertEquals("9.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_연산순서_괄호_뺄셈_나눗셈() {
		this._calc = new Calculate();
		this._calc.setInfix("(3-6)/3");
		this._calc.infix2Postfix();
		assertEquals("-1.0", ""+this._calc.evalPostfix());
	}
}
