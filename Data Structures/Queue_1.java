// https://www.acmicpc.net/problem/10845

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class algorithm {
    public static void main(String[] args) throws IOException{
        Deque<Integer> queue = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =  new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = null;

        int num = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i<num; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            switch (stringTokenizer.nextToken()) {

                case "push":
                    queue.add(Integer.parseInt(stringTokenizer.nextToken()));
                    break;

                case "pop":
                    if(!queue.isEmpty())
                        bufferedWriter.write(queue.poll() + "\n");
                    else 
                        bufferedWriter.write(-1 + "\n");
                    break;
                case "size":
                    bufferedWriter.write(queue.size() + "\n");
                    break;
                case "empty":
                    if(queue.isEmpty())
                        bufferedWriter.write(1 + "\n");
                    else
                        bufferedWriter.write(0 + "\n");
                    break;
                case "front":
                    if(!queue.isEmpty())
                        bufferedWriter.write(queue.peek() + "\n");
                    else
                        bufferedWriter.write(-1 + "\n");
                    break;
                case "back":
                    if(!queue.isEmpty())
                        bufferedWriter.write(queue.peekLast() + "\n");
                    else
                        bufferedWriter.write(-1 + "\n");
                    break;
            }
        }
        
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
        
    }
}