// https://www.acmicpc.net/problem/9012

import java.io.*;
import java.util.Stack;

class Parenthesis {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>(); // 자바SE7 이후부터 generic 생략 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // System.in은 콘솔(터미널 등)로부터 입력(키보드) 받는 것을 의미한다.

        int count = Integer.parseInt(br.readLine()); // 숫자 입력 받는다.

        for(int i=0; i<count; i++){
            boolean isError = false; // 에러 유무 확인 변수

            String str = br.readLine(); // VPS 입력 받는다.

            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);

                if(c == '(')
                    stack.push(Character.toString(c)); // Generic이 String 이므로 형변환 해준다.

                else if(c == ')') {
                    if(!stack.empty())
                        stack.pop();
                    else {
                        isError = true;
                        break;
                    }
                }
                else {
                    isError = true;
                    break;
                }

            }

            if(stack.empty() && isError == false)
                System.out.println("YES");
            else
                System.out.println("NO");
            stack.clear();
        }

        br.close();
    }
}

