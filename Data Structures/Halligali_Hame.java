// https://www.acmicpc.net/problem/20923

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Halligali_Hame {
    public static void main(String[] args) throws IOException{
        
        Deque<Integer> do_Deque = new ArrayDeque<>();
        Deque<Integer> su_Deque = new ArrayDeque<>();
        Deque<Integer> do_ground_Deque = new ArrayDeque<>();
        Deque<Integer> su_ground_Deque = new ArrayDeque<>();

        StringTokenizer stringTokenizer;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        int cardIndex = Integer.parseInt(stringTokenizer.nextToken()); 
        int gameCount = Integer.parseInt(stringTokenizer.nextToken()); 

        for(int i = 0; i<cardIndex; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            do_Deque.addFirst(Integer.parseInt(stringTokenizer.nextToken()));
            su_Deque.addFirst(Integer.parseInt(stringTokenizer.nextToken()));
        }
        
        int do_card = 0;
        int su_card = 0;

        for(int i = 0; i<gameCount; i++) {
            // dodo 차례
            if(i%2==0) {
                do_card = do_Deque.poll();
                if(do_Deque.size() == 0) {
                    System.out.println("su");  
                    return ;
                }
                do_ground_Deque.add(do_card);
                
                if(do_card == 5 || su_card == 5) {
                    do_Deque.addAll(su_ground_Deque);
                    do_Deque.addAll(do_ground_Deque);
                    do_ground_Deque.clear();
                    su_ground_Deque.clear();
                    do_card = 0;
                    su_card = 0;
                }
                else if(do_card + su_card == 5) {
                    su_Deque.addAll(do_ground_Deque);
                    su_Deque.addAll(su_ground_Deque);
                    do_ground_Deque.clear();
                    su_ground_Deque.clear();
                    do_card = 0;
                    su_card = 0;
                }
            }
            // su 차례
            if(i%2==1) {
                su_card = su_Deque.poll();
                if(su_Deque.size() == 0) {
                    System.out.println("do");  
                    return ;
                }
                su_ground_Deque.add(su_card);

                if(do_card == 5 || su_card == 5) {
                    do_Deque.addAll(su_ground_Deque);
                    do_Deque.addAll(do_ground_Deque);
                    do_ground_Deque.clear();
                    su_ground_Deque.clear();
                    do_card = 0;
                    su_card = 0;
                }

                else if(do_card + su_card == 5) {
                    su_Deque.addAll(do_ground_Deque);
                    su_Deque.addAll(su_ground_Deque);
                    do_ground_Deque.clear();
                    su_ground_Deque.clear();
                    do_card = 0;
                    su_card = 0;
                }
            }
        }

        if(do_Deque.size() > su_Deque.size())
            System.out.println("do");
        else if(do_Deque.size() < su_Deque.size())
            System.out.println("su");   
        else 
            System.out.println("dosu"); 
        
    }
}
