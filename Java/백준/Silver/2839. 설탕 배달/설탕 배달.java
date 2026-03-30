import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=-1;
        dp[2]=-1;
        if(n>=3) dp[3]=1;
        if(n>=4) dp[4]=-1;
        if(n>=5){
            for(int i=5; i<=n; i++){
                dp[i]=-1;
                if(dp[i-3]!=-1 && dp[i-5]!=-1){
                    dp[i]=Math.min(dp[i-3]+1,dp[i-5]+1);
                }
                else if(dp[i-3]!=-1){
                    dp[i]= dp[i-3]+1;
                }
                else if(dp[i-5]!=-1){
                    dp[i]= dp[i-5]+1;
                }

            }
        }


        System.out.println(dp[n]);

    }
}
