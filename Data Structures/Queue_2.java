// https://www.acmicpc.net/problem/18258

import java.io.*;
import java.util.*;

public class Queue_2 {

    public static void main(String[] args) throws IOException {
        Deque<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()) {

                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    if(!queue.isEmpty())
                        bw.write(String.valueOf(queue.poll()) +"\n");
                    else
                        bw.write(-1 + "\n");
                    break;

                case "size":
                    bw.write(String.valueOf(queue.size()) +"\n");
                    break;

                case "empty":
                    if(!queue.isEmpty())
                        bw.write(0 + "\n");
                    else
                        bw.write(1 + "\n");
                    break;

                case "front":
                    if(!queue.isEmpty())
                        bw.write(String.valueOf(queue.peek()) +"\n");
                    else
                        bw.write(-1 + "\n");
                    break;

                case "back":
                    if(!queue.isEmpty())
                        bw.write(String.valueOf(queue.peekLast()) +"\n");
                    else
                        bw.write(-1 + "\n");
                    break;

            }

        }
        bw.flush(); // 출력
        br.close();
        bw.close();
    }
}
