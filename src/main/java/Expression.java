public class Expression {
    private float firstOperator;
    private float secondOperator;
    private char operation;

    public Expression(String expression) {
        expression = expression.replaceAll("\\s+", "");
        findOperation(expression);
        int index = expression.indexOf(operation);
        this.firstOperator = Float.parseFloat(expression.substring(0, index));
        this.secondOperator = Float.parseFloat(expression.substring(index + 1));
    }

    private void findOperation(String expression) {
        if (expression.indexOf('+') != -1)
            this.operation = '+';
        else if (expression.indexOf('-') != -1)
            this.operation = '-';
        else if (expression.indexOf('*') != -1)
            this.operation = '*';
        else if (expression.indexOf('/') != -1)
            this.operation = '/';
    }

    public float getResult() {
        switch (operation) {
            case '+':
                return Operation.ADDITION.action(firstOperator, secondOperator);
            case '-':
                return Operation.SUBTRACTION.action(firstOperator, secondOperator);
            case '/':
                return Operation.DIVISION.action(firstOperator, secondOperator);
            case '*':
                return Operation.MULTIPLICATION.action(firstOperator, secondOperator);
            default:
                return 0;
        }
    }
}
