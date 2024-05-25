import java.util.Stack;

public class evaluateInfix {
    public static char operation(char v1, char operator, char v2){
        float v11 = v1 -'0';
        float v22 = v2 -'0';
        if(operator == '+') return (char) ((v11 + v22) + '0');
        else if(operator == '-') return (char)((v11 - v22) + '0');
        else if(operator == '*') return (char)((v11 * v22) + '0');
        else if(operator == '/') return (char)((v11 / v22) + '0');
        else return '0';
    }
    public static int precedence(char op){
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return -1;
    }
    public static char infixAns(String eval){
        Stack<Character> op = new Stack<>();
        Stack<Character> val = new Stack<>();

        for(int i = 0 ; i < eval.length() ; i++){
            char ch = eval.charAt(i);
            if(ch >= '0' && ch <= '9') val.push(ch);
            else if(ch == '('){
                op.push(ch);
            }
            else if(ch == ')'){
                while(op.peek() != '('){
                    char v2 = val.pop();
                    char v1 = val.pop();
                    char operator = op.pop();
                    char toBePushed = operation(v1, operator, v2);
                    val.push(toBePushed);
                }
                op.pop();
            }
            else if(ch == '*' || ch == '/' || ch == '+' || ch == '-'){
                if(op.empty()){
                    op.push(ch);
                }
                else{
                    while(!op.empty() && precedence(op.peek()) >= precedence(ch)){
                        char v2 = val.pop();
                        char v1 = val.pop();
                        char operator = op.pop();
                        char toBePushed = operation(v1, operator, v2);
                        val.push(toBePushed);
                    }
                    op.push(ch);
                }
            }
        }
        while(!op.empty()){
            char v2 = val.pop();
            char v1 = val.pop();
            char operator = op.pop();
            char toBePushed = operation(v1, operator, v2);
            val.push(toBePushed);
        }

        return val.pop();
    }
    public static void main(String[] args) {
        String eval = "9-(5+3)*4/6  ";
        Stack<Integer> val = new Stack<>();
        char ans = infixAns(eval);
        System.out.println(ans);
    }
}
