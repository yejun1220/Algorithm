// https://www.acmicpc.net/problem/1874

import java.io.*;
import java.util.*;

class StackSequence {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    
    int N = Integer.parseInt(br.readLine());
   
    for(int i = 0; i < N; i++) { // 확인할 숫자들 입력
      list.add(Integer.parseInt(br.readLine()));
    }

    int j = 0;
    for(int i = 1; i <= N; i++) {
        stack.push(i);
        sb.append('+').append('\n');

        while (!stack.empty() && stack.peek() == list.get(j)) { // 스택의 끝만 확인
            stack.pop();
            sb.append('-').append('\n');
            j++;
          
      }
    }
    
    if(!stack.empty())
      System.out.println("NO");
    else
      System.out.println(sb);

    br.close();
  }
}