import java.util.Stack;

public class InfixToPostFix {
        //Tells if a character is operator
    public static boolean isOperator(char ch){
        if(ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '^') return true;
        return false;
    }
    //Valid Literal
    public static boolean isValid(char ch){
        if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) return true;
        return false;
    }
    //Tells the precedence
    public static int precendence(char ch){
        if(ch == '^') return 3;
        if(ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        return -1;
    }
    public static void main(String[] args) {
        String rev = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(rev);
        String ans = "";

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < rev.length() ; i++){
            char ch = rev.charAt(i);
            if(isValid(ch)){
                ans += ch;
            }
            else if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                while(!stack.empty() && stack.peek() != '('){
                    ans += stack.pop();
                }
                //remove ) from stack
                stack.pop();
            }
            else if(isOperator(ch)){
                while(!stack.empty() && precendence(stack.peek()) >= precendence(ch)){
                    ans += stack.pop();
                }
                stack.push(ch);
            }
        }
        while(!stack.empty()){
            ans += stack.pop();
        }
        System.out.println("The required expression is " + ans);
    }
}
