public class PrefixToInfix {
     public boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                return true;
        }
        return false;
    }
    public String convert(String str) {
        StringDoubleEndedQueueImpl deque = new StringDoubleEndedQueueImpl();

        int l = str.length();  // Length of expression


        for (int i = l - 1; i >= 0; i--) {  // Reading from right to left
            char c = str.charAt(i);
            if (isOperator(c)) {
                String op1 = deque.removeFirst();
                String op2 = deque.removeFirst();

                // Concat the operands and operator
                String temp = "(" + op1 + c + op2 + ")";
                deque.addFirst(temp);
            } else {
                // To make character to string
                deque.addFirst(c + "");
            }
        }
        return deque.removeFirst();
        deque.printQueue();
    }


}
