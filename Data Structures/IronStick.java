import java.io.*;
import java.util.*;

class IronStick{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        String s = scan.next();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)== '(') // '(' 일 때
                stack.push(i);

            else { // ')' 일 때
                if(stack.peek() == i-1) { // 레이저일 때
                    stack.pop();
                    count+=stack.size();
                }

                else { // 파이프의 끝일 때
                    stack.pop();
                    count++;
                }
            }
        }
        System.out.println(count);
    }
 
}
