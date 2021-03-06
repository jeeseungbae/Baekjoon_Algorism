package backjun.Classes.silver.silver2.호텔_s1106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. 입력 및 초기화
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int C = Integer.parseInt(st.nextToken()); // 최소 고객 달성
        int N = Integer.parseInt(st.nextToken()); // 도시 개수

        int[] dp = new int[C+101]; // 달성고객 + 최대 도시고객
        Arrays.fill(dp, INF);
        dp[0] = 0;

        // 2. DP ( 호텔의 고객을 'i' 명 늘리기 위해 투자해야 하는 최소비용 )
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(in.readLine(), " ");
            int cost     = Integer.parseInt(st.nextToken()); // 비용
            int customer = Integer.parseInt(st.nextToken()); // 고객
            for(int i=customer; i<C+101; i++) {
                dp[i] = Math.min(dp[i], cost + dp[i - customer]);
            }
        }

        // 3. 최소값 출력
        int ans = INF;
        for(int i=C; i<C+101; i++) ans = Math.min(ans, dp[i]);
        System.out.println(ans);
    }

}
