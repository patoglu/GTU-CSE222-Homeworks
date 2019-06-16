import java.util.EmptyStackException;


public class Calculator {
    private SushiStack patogluStack;
    private String[] tokens;
    private String[] tokensToArray;
    private final static String[] operations = {"sin","cos","abs","(", ")", "+", "-", "*", "/"};
    private final static int[] operatorPrecedence = {4,4,4,3,3,1,1,2,2};

    /**
     * One parameter constructor.
     * @param expression
     */
    public Calculator(String expression)
    {
        generateExpression(expression);
    }

    /**
     *
     * @param token inputToken
     * @return true if operand.
     */
    private boolean isOperand(String token)
    {
        boolean operand = true;
        for(int i = 0 ; i < operations.length ; ++i)
        {
            if(operations[i].equals(token))
            {
                operand = false;
            }
        }
        return operand;
    }

    /**
     *
     * @param token the input token
     * @return returns the operator power.
     */
    private int operatorPower(String token)
    {
        for (int i = 0 ; i < operations.length ; ++i)
        {
            if(token.equals(operations[i]))
            {
                return operatorPrecedence[i];
            }
        }
        return 1;
    }

    /**
     *
     * @param expression inputExpression.
     */
    public void generateExpression(String expression)
    {
        int paranthesisCount = 0;
        int cursor = 0;
        int depot = 0;
        patogluStack = new SushiStack();

        tokens = expression.split(" ");
        System.out.println(tokens.length);
        tokensToArray = new String[tokens.length];
        while(cursor < tokens.length)
        {

            if(isOperand(tokens[cursor]))
            {
                tokensToArray[depot] = tokens[cursor];
                ++cursor;
                ++depot;
            }
            else if(tokens[cursor].equals("("))
            {
                paranthesisCount++;
                patogluStack.pushElement("(");
                cursor++;
            }
            else if(tokens[cursor].equals(")"))
            {
                paranthesisCount++;
                String token = "(";
                while(!token.equals(patogluStack.peek()))
                {

                    tokensToArray[depot] = patogluStack.pop();
                    depot++;
                }
                patogluStack.pop();
                cursor++;
            }
            else if((!isOperand(tokens[cursor])) && (patogluStack.empty() || patogluStack.peek().equals("(")))
            {
                patogluStack.pushElement(tokens[cursor]);
                cursor++;
            }
            else if((!isOperand(tokens[cursor])) && (operatorPower(tokens[cursor]) >= operatorPower(patogluStack.peek())))
            {
                patogluStack.pushElement(tokens[cursor]);
                cursor++;
            }
            else if((!isOperand(tokens[cursor])) && (operatorPower(tokens[cursor]) < operatorPower(patogluStack.peek())))
            {
                while((patogluStack.topElement != -1) && (operatorPower(tokens[cursor]) < operatorPower(patogluStack.peek())) )
                {
                    tokensToArray[depot] = patogluStack.pop();
                    depot++;

                }
                patogluStack.pushElement(tokens[cursor]);
                cursor++;
            }
        }

        while(!patogluStack.empty())
        {
            tokensToArray[depot] = patogluStack.pop();
        }
        for (int i = 0 ; i < tokensToArray.length - paranthesisCount ; ++i)
        {
            System.out.print(tokensToArray[i] +  " ");
        }
    }
}
