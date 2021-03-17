import java.util.ArrayList;

public class Client {

	private CalculatorVisitor calculatorVisitor;

	public int evaluateExpression(ArrayList<Token> tokenList) {
		calculatorVisitor = new CalculatorVisitor();
		for (int i = 0; i < tokenList.size(); i++) {
			 tokenList.get(i).accept(calculatorVisitor);
		}
		try {
			return calculatorVisitor.getResult();
		} catch (MalformedExpressionException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
