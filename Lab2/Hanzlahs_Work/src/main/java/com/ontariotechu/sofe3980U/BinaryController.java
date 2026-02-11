package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BinaryController {

	@GetMapping("/")
	public String getCalculator(@RequestParam(name="operand1", required=false, defaultValue="") String operand1, Model model) {
		operand1 = operand1.trim();
		model.addAttribute("operand1", operand1);
		model.addAttribute("operand1Focused", operand1.length()>0);
		return "calculator";
	}

	@PostMapping("/")
	public String result(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
						 @RequestParam(name="operator", required=false, defaultValue="") String operator ,
						 @RequestParam(name="operand2", required=false, defaultValue="") String operand2, Model model) {

		operand1 = operand1.trim();
		operand2 = operand2.trim();
		operator = operator.trim();

		model.addAttribute("operand1", operand1);
		model.addAttribute("operator", operator);
		model.addAttribute("operand2", operand2);

		// Basic validation to prevent crashes if inputs are empty
		if (operand1.length() == 0 || operand2.length() == 0 || operator.length() == 0) {
			return "error";
		}

		Binary number1;
		Binary number2;

		try {
			number1 = new Binary(operand1);
			number2 = new Binary(operand2);
		} catch (Exception e) {
			return "error";
		}

		Binary output;

		// Updated switch to handle Multiply (*), AND (&), and OR (|)
		switch(operator)
		{
			case "+":
				output = Binary.add(number1,number2);
				break;
			case "*":
				output = Binary.Multiply(number1,number2);
				break;
			case "&":
				output = Binary.AND(number1,number2);
				break;
			case "|":
				output = Binary.OR(number1,number2);
				break;
			default:
				return "error"; // Matching the template name "error.html"
		}

		model.addAttribute("result", output.getBinary());
		return "result";
	}

}
