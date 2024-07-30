import java.util.Scanner;
import java.util.Stack;
class Main { 
    public static String convert(String infix) {
        String reversed = new StringBuilder(infix).reverse().toString();
        reversed = swap(reversed);

        String postfix = ConvertToPostfix(reversed);
        return new StringBuilder(postfix).reverse().toString();
    }

    private static String ConvertToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for(char c : infix.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                while(!stack.isEmpty() && stack.peek()!='(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while(!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static int priority(char operator) {
        switch(operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    private static String swap(String str) {
        StringBuilder result = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(c == '(') result.append(')');
            else if(c == ')') result.append('(');
            else result.append(c);
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Expression: ");
        String infix = sc.next();
        System.out.println("Infix: "+infix);
        System.out.println("Prefix: "+convert(infix));
    }
}
