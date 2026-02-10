package com.ontariotechu.sofe3980U;

public class BinaryAPIResult {
	private String operand1;
	private String operator;
	private String operand2;
	private String result;

	public BinaryAPIResult(Binary operand1, String operator, Binary operand2, Binary result)
	{
		// Changed .getValue() to .getBinary() to match your Binary class
		this.operand1 = operand1.getBinary();
		this.operator = new String(operator);
		this.operand2 = operand2.getBinary();
		this.result = result.getBinary();
	}

	public String getOperand1(){
		return operand1;
	}
	public String getOperator(){
		return operator;
	}
	public String getOperand2(){
		return operand2;
	}
	public String getResult(){
		return result;
	}
}