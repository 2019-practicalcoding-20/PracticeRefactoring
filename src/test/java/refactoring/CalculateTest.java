package refactoring;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {
	Calculate _calc;
	@Test
	public void infix2Postfix_����() {
		this._calc = new Calculate();
		this._calc.setInfix("1+1");
		this._calc.infix2Postfix();
		assertEquals("11+", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_����() {
		this._calc = new Calculate();
		this._calc.setInfix("1-1");
		this._calc.infix2Postfix();
		assertEquals("11-", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_����() {
		this._calc = new Calculate();
		this._calc.setInfix("1*1");
		this._calc.infix2Postfix();
		assertEquals("11*", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_������() {
		this._calc = new Calculate();
		this._calc.setInfix("1/1");
		this._calc.infix2Postfix();
		assertEquals("11/", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_��ⷯ() {
		this._calc = new Calculate();
		this._calc.setInfix("1%1");
		this._calc.infix2Postfix();
		assertEquals("11%", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_����() {
		this._calc = new Calculate();
		this._calc.setInfix("1^1");
		this._calc.infix2Postfix();
		assertEquals("11^", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_�������_����_����() {
		this._calc = new Calculate();
		this._calc.setInfix("1+2*3");
		this._calc.infix2Postfix();
		assertEquals("123*+", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_�������_����_����_����() {
		this._calc = new Calculate();
		this._calc.setInfix("1+2*3^4");
		this._calc.infix2Postfix();
		assertEquals("1234^*+", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_�������_����_������() {
		this._calc = new Calculate();
		this._calc.setInfix("1-2/3");
		this._calc.infix2Postfix();
		assertEquals("123/-", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_�������_��ȣ_����_����() {
		this._calc = new Calculate();
		this._calc.setInfix("(1+2)*3");
		this._calc.infix2Postfix();
		assertEquals("12+3*", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_�������_��ȣ_����_������() {
		this._calc = new Calculate();
		this._calc.setInfix("(1-2)/3");
		this._calc.infix2Postfix();
		assertEquals("12-3/", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_ū����() {
		this._calc = new Calculate();
		this._calc.setInfix("1-2/3+125123415123415123415134");
		this._calc.infix2Postfix();
		assertEquals("123/-125123415123415123415134+", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_ū����_������() {
		this._calc = new Calculate();
		this._calc.setInfix("1849723845792-2834793475/323523457568687+125123415123415123415134");
		this._calc.infix2Postfix();
		assertEquals("18497238457922834793475323523457568687/-125123415123415123415134+", this._calc.postfix());
	}
	@Test
	public void infix2Postfix_�Ҽ�() {
		this._calc = new Calculate();
		this._calc.setInfix("1.1-2/3");
		this._calc.infix2Postfix();
		assertEquals("1.123/-", this._calc.postfix());
	}
	
	
	
	@Test
	public void evalPostfix_����() {
		this._calc = new Calculate();
		this._calc.setInfix("1+1");
		this._calc.infix2Postfix();
		assertEquals("2.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_����() {
		this._calc = new Calculate();
		this._calc.setInfix("1-1");
		this._calc.infix2Postfix();
		assertEquals("0.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_����() {
		this._calc = new Calculate();
		this._calc.setInfix("8*4");
		this._calc.infix2Postfix();
		assertEquals("32.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_������_�������() {
		this._calc = new Calculate();
		this._calc.setInfix("8/4");
		this._calc.infix2Postfix();
		assertEquals("2.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_������_�Ҽ����() {
		this._calc = new Calculate();
		this._calc.setInfix("4/8");
		this._calc.infix2Postfix();
		assertEquals("0.5", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_��ⷯ() {
		this._calc = new Calculate();
		this._calc.setInfix("9%4");
		this._calc.infix2Postfix();
		assertEquals("1.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_����() {
		this._calc = new Calculate();
		this._calc.setInfix("2^5");
		this._calc.infix2Postfix();
		assertEquals("32.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_�������_����_����() {
		this._calc = new Calculate();
		this._calc.setInfix("1+2*3");
		this._calc.infix2Postfix();
		assertEquals("7.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_�������_����_������() {
		this._calc = new Calculate();
		this._calc.setInfix("3-9/3");
		this._calc.infix2Postfix();
		assertEquals("0.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_�������_��ȣ_����_����() {
		this._calc = new Calculate();
		this._calc.setInfix("(1+2)*3");
		this._calc.infix2Postfix();
		assertEquals("9.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_�������_��ȣ_����_������() {
		this._calc = new Calculate();
		this._calc.setInfix("(3-6)/3");
		this._calc.infix2Postfix();
		assertEquals("-1.0", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_ū����() {
		this._calc = new Calculate();
		this._calc.setInfix("1-6/3+125123415123415123415134");
		this._calc.infix2Postfix();
		assertEquals("125123415123415123415133", ""+this._calc.evalPostfix());
	}
	@Test
	public void evalPostfix_�Ҽ�() {
		this._calc = new Calculate();
		this._calc.setInfix("1.1-2/4");
		this._calc.infix2Postfix();
		assertEquals("0.6", this._calc.postfix());
	}
}
