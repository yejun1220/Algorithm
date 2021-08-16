// https://www.acmicpc.net/problem/1168

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Josephus_2 {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int index = 0;
        bw.write('<' + "");

        for(int i=0; i<N; i++) {
            list.add(i+1);
        }

        while(!list.isEmpty()) {
            for(int i=0; i<N; i++) {
                index += K-1;
                if(index > list.size())
                    index %= list.size();

                if(list.size() != 1)
                    bw.write(list.remove(index) + ", ");

                else
                    bw.write(list.remove(index) + ">");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}