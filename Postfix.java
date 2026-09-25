public class Postfix {

    public static int evaluate(String expression) {

        Stack stack = new Stack(100);
        String[] parts = expression.trim().split("\\s+");

        for (int i = 0; i < parts.length; i++) {

            String part = parts[i];

            if (part.equals("+") ||
                part.equals("-") ||
                part.equals("*") ||
                part.equals("/") ||
                part.equals("×") ||
                part.equals("÷")) {

                if (stack.size() < 2) {
                    System.out.println("Invalid postfix expression.");
                    return 0;
                }

                int right = stack.pop();
                int left = stack.pop();

                int answer = 0;

                if (part.equals("+")) {
                    answer = left + right;
                }

                else if (part.equals("-")) {
                    answer = left - right;
                }

                else if (part.equals("*") || part.equals("×")) {
                    answer = left * right;
                }

                else if (part.equals("/") || part.equals("÷")) {

                    if (right == 0) {
                        System.out.println("Cannot divide by zero.");
                        return 0;
                    }

                    answer = left / right;
                }

                System.out.println(left + " " + part + " " + right + " = " + answer);

                stack.push(answer);

                System.out.print("Current stack: ");
                stack.display();

            } else {

                int number = Integer.parseInt(part);

                stack.push(number);

                System.out.println("Pushed: " + number);

                System.out.print("Current stack: ");
                stack.display();
            }
        }

        if (stack.size() == 1) {
            return stack.pop();
        }

        System.out.println("Invalid postfix expression.");
        return 0;
    }
}