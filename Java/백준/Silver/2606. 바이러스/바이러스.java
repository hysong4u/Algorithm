import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<m; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph.get(a-1).add(b-1);
            graph.get(b-1).add(a-1);

        }

        //System.out.println(graph);
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[m];
        queue.offer(0);
        visited[0]=true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            //System.out.println("now"+now);

            for(int node:graph.get(now)){
                if(!visited[node]){
                    queue.offer(node);
                    visited[node]=true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);





    }






}
