package twoStack;

import java.util.Stack;

public class TwoStack {

    private final static Stack<String> operators = new Stack<>();
    private final static Stack<Double> values = new Stack<>();

    public static void main(String[] args) {
        String[] expression = {"(", "1", "+", "(", "(", "2", "+", "3", ")", "*", "(", "4", "*", "5", ")", ")", ")"};

        Double function = function(expression);
        System.out.println(function);
    }

    private static Double function(String[] expression) {
        for (String val : expression) {
            if (val.equals("(")) ;
            else if (val.equals("+")) operators.push(val);
            else if (val.equals("*")) operators.push(val);
            else if (val.equals(")")) {
                String operator = operators.pop();
                if (operator.equals("+")) values.push(values.pop() + values.pop());
                else if (operator.equals("*")) values.push(values.pop() * values.pop());
            } else {
                values.push(Double.parseDouble(val));
            }

        }
        return values.pop();
    }
}
