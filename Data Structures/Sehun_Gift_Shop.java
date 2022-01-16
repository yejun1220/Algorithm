// https://www.acmicpc.net/problem/17225

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Sehun_Gift_Shop {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Order> priorityQueue = new PriorityQueue<>();
        StringTokenizer stringTokenizer;
        ArrayList<Integer> blueList = new ArrayList<>();
        ArrayList<Integer> redList = new ArrayList<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int blueOrderTime = Integer.parseInt(stringTokenizer.nextToken());
        int redOrderTime = Integer.parseInt(stringTokenizer.nextToken());
        int customerNumber = Integer.parseInt(stringTokenizer.nextToken());

        int blueEndTime = 0;
        int redEndTime = 0;
        for(int i = 0; i<customerNumber; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int startTime = Integer.parseInt(stringTokenizer.nextToken());
            String color = stringTokenizer.nextToken();
            int counter = Integer.parseInt(stringTokenizer.nextToken());

            if(color.equals("B")) {
                if(blueEndTime <= startTime) {
                    for (int j = 0; j < counter; j++) {
                        
                        priorityQueue.add(new Order(startTime, "B"));
                        startTime += blueOrderTime;
                        blueEndTime = startTime;
                    }
                }
                else {
                    startTime = blueEndTime;
                    for (int j = 0; j < counter; j++) {
                        priorityQueue.add(new Order(startTime, "B"));
                        startTime += blueOrderTime;
                        blueEndTime = startTime;
                    }
                }
            }
            else {
                if(redEndTime <= startTime) {
                    for (int j = 0; j < counter; j++) {
                        priorityQueue.add(new Order(startTime, "R"));
                        startTime += redOrderTime;
                        redEndTime = startTime;
                    }
                }
                else {
                    startTime = redEndTime;
                    for (int j = 0; j < counter; j++) {
                        priorityQueue.add(new Order(startTime, "R"));
                        startTime += redOrderTime;
                        redEndTime = startTime;
                    }
                }
            }
        }

        int tempNumber = 1;
        while (!priorityQueue.isEmpty()) {
            
            Order order = priorityQueue.poll();

            if(order.color.equals("B"))
                blueList.add(tempNumber);
            else
                redList.add(tempNumber);
            tempNumber++;
        }

        System.out.println(blueList.size());
        for (Integer integer : blueList) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println(redList.size());
        for (Integer integer : redList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    private static class Order implements Comparable<Order>{
        private int startTime;
        private String color;

        Order(int startTime, String color) {
            this.startTime = startTime;
            this.color = color;
        }

        @Override
        public int compareTo(Order order) {
            // System.out.println("compare this" + this.color + this.startTime);
            // System.out.println("compare order" + order.color + order.startTime);
            if (this.startTime == order.startTime && this.color.equals("B"))
                return -1;
            else if (this.startTime == order.startTime && this.color.equals("R"))
                return 1;
            return this.startTime - order.startTime;
           
        }
    }
}