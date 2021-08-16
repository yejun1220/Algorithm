// https://www.acmicpc.net/problem/2164

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Card_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(bufferedReader.readLine());

        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while(q.size() > 1) {
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll());
        bufferedReader.close();
    }
}