import java.util.Stack;

public class PostfixEval {
     public static boolean isOperator(char ch){
        return (ch == '*' || ch == '-' || ch == '/' || ch == '+');
    }
    public static boolean isNum(char ch){
        return (ch >= '0' && ch <= '9');
    }
    public static int operation(int val1, char oper, int val2){
        if(oper == '+') return val1 + val2;
        else if(oper == '-') return val1 - val2;
        else if(oper == '*') return val1 * val2;
        else return val1 / val2;
    }
    public static void main(String[] args) {
        String s = "231*+9-";
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(isNum(s.charAt(i))){
                stack.push(s.charAt(i) - '0');
            }
            else if(isOperator(s.charAt(i))){
                char ch = s.charAt(i);
                int val2 = stack.pop();
                int val1 = stack.pop();
                int ans = operation(val1, ch, val2);
                stack.push(ans);
            }
        }
        System.out.println("The required ans is " + stack.pop());
    }
}
