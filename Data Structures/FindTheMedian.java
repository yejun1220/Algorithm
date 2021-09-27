// https://www.acmicpc.net/problem/2696

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class FindTheMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
 
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = 0; // 줄 간격 띄우기 위한 용도

            int N = Integer.parseInt(br.readLine()); // 배열의 크기
 
            sb.append(((N + 1) / 2) + "\n"); // 중앙값의 개수 출력

            for (int i = 0; i < N; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
 
                int x = Integer.parseInt(st.nextToken());
                list.add(x);
                Collections.sort(list);
                
                // 중앙값 stringbuilder에 추가
                if (i % 2 == 0) {
                    // 10번째거나 끝에 도달했을 때
                    if (cnt == 9 || i == N - 1) {
                        sb.append(list.get(i / 2) + "\n");

                        cnt = 0;
                    }
                    else {
                        sb.append(list.get(i / 2) + " ");
                    }
                    cnt++;
                }
            }
        }  

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
}
