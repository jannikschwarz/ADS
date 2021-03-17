import java.util.EmptyStackException;

public class CalculatorVisitor implements Visitor, Calculator {

	private LinkedStack<Token> tokenStack;

	private void pushOperand(Operand operand) {
		tokenStack.push(operand);
	}

	private void performOperation(Operator operator) throws MalformedExpressionException {
		try{
			Operand rightOperand = (Operand) tokenStack.pop();
			Operand leftOperand = (Operand) tokenStack.pop();
			if(operator.getOperation() == Operation.PLUS){
				int newInt = leftOperand.getValue() + rightOperand.getValue();
				tokenStack.push(new Operand(newInt));
			}else if(operator.getOperation() == Operation.MINUS){
				int newInt = leftOperand.getValue() - rightOperand.getValue();
				tokenStack.push(new Operand(newInt));
			}else if(operator.getOperation() == Operation.MULTIPLY){
				int newInt = leftOperand.getValue() * rightOperand.getValue();
				tokenStack.push(new Operand(newInt));
			}else if(operator.getOperation() == Operation.DIVIDE){
				if(rightOperand.getValue() == 0){
					tokenStack.push(new Operand(0));
				}
				int newInt = leftOperand.getValue() / rightOperand.getValue();
				tokenStack.push(new Operand(newInt));
			}
		}catch (EmptyStackException e){
			throw new MalformedExpressionException("Invalid token expression");
		}
	}

	public void visit(Operand operand) {
		tokenStack.push(operand);
	}


	public void visit(Operator operator) {
		try {
			performOperation(operator);
		} catch (MalformedExpressionException e) {
			e.printStackTrace();
		}
	}

	public int getResult() throws MalformedExpressionException{
		Token tempTop = tokenStack.pop();
		if(tempTop == null){
			throw new MalformedExpressionException("Invalid token expression");
		}
		Operand toReturn = (Operand) tempTop;
		return toReturn.getValue();
	}
}
