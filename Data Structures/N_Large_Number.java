// https://www.acmicpc.net/problem/2075

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N_Large_Number {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer stringTokenizer;

        int num = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i<num; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            while(stringTokenizer.hasMoreElements()) {
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                priorityQueue.add(temp);
            }
        }

        for(int i = 1; i<num; i++) {
            priorityQueue.poll();
        }

        System.out.println(priorityQueue.poll());
    }
}
