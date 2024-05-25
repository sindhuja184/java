import java.util.Stack;

public class PrefixToPostfix {
     public static boolean isOperator(char ch){
        return (ch == '*' || ch == '-' || ch == '/' || ch == '+');
    }
    public static boolean isValid(char ch){
        if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) return true;
        return false;
    }
    public static void main(String[] args) {
        String s = "*+AB-CD";
        Stack<String> stack = new Stack<>();

        for(int i = s.length() - 1; i >= 0 ; i--){
            char ch = s.charAt(i);
            String g = ""+ch;
            if(isValid(ch)){
                stack.push(g);
            }
            else if(isOperator(ch)){
                String p1 = stack.pop();
                String p2 = stack.pop();
                String op = "" + ch;
                stack.push(p1+p2+op);
            }
        }
        String a = stack.pop();
        System.out.println(a);

    }
}
