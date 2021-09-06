// https://www.acmicpc.net/problem/1918

import java.io.*;
import java.util.*;

class PostfixExpression {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap<>();

		map.put('(', 0);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);

    String input = br.readLine();
    char[] charArray = input.toCharArray();

    for(char ch: charArray) {
      if('A' <= ch && ch <= 'Z')
        sb.append(ch);
      
      else if(ch == '(')
        stack.push(ch);

      else if(ch == ')') {
        while(!stack.isEmpty() && stack.peek() != '(')
          sb.append(stack.pop());

        if(!stack.isEmpty()) // stack이 비어있을 수 있으므로
          stack.pop();
      }

      else {// 연산자
        while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(ch))
						sb.append(stack.pop());
        stack.push(ch);
      }
    }

    while(!stack.isEmpty())
      sb.append(stack.pop());
  
    System.out.println(sb.toString());

    br.close();
  }
}