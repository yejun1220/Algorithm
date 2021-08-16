import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class PostfixExpression_2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Character, Integer> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);

            if ('A' <= temp && temp <= 'Z'&& map.containsKey(temp) == false) {
                map.put(temp, Integer.parseInt(br.readLine()));
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ('A' <= ch && ch <= 'Z') {
                stack.push((double) map.get(ch));
            }

            else {
                double b = stack.pop();
                double a = stack.pop();

                switch (ch) {
                    case '+':
                        double n = a + b;
                        stack.push(n);
                        break;

                    case '-':
                        n = a - b;
                        stack.push(n);
                        break;

                    case '*':
                        n = a * b;
                        stack.push(n);
                        break;

                    case '/':
                        n = a / b;
                        stack.push(n);
                        break;
                }

            }
        }
        bw.write(String.format("%.2f",stack.pop()));
        bw.flush();

    }
}