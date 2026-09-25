public class Stack {

    private int[] values;
    private int top;

    public Stack(int size) {
        values = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == values.length - 1) {
            System.out.println("Stack is full.");
        } else {
            top++;
            values[top] = value;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return 0;
        }

        int value = values[top];
        top--;

        return value;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return 0;
        }

        return values[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");

            for (int i = top; i >= 0; i--) {
                System.out.print(values[i] + " ");
            }

            System.out.println();
        }
    }
}