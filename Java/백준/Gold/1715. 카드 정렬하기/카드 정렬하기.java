import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int num = scanner.nextInt();
            pq.offer(num);
        }
        if(n==1) {
            System.out.println(0);
            return;
        }

        while(pq.size()>1){
            int sum = pq.poll()+pq.poll();
            answer+=sum;
            pq.offer(sum);

        }

        System.out.println(answer);

    }
}
