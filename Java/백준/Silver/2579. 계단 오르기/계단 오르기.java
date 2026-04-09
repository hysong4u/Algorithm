import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] step= new int[n];
        int[] dp= new int[n];

        for(int i=0; i<n; i++){
            step[i] = scanner.nextInt();
        }

        dp[0]=step[0];
        if(n>1) dp[1]= step[0] + step[1];
        if(n>2) dp[2]= Math.max(step[0]+step[2], step[1]+step[2]);
        if(n>3){
            for(int i=3; i<n; i++){
                dp[i] = Math.max(dp[i-2]+ step[i], dp[i-3] + step[i-1] + step[i]);
            }

        }
        System.out.println(dp[n-1]);


    }

}
