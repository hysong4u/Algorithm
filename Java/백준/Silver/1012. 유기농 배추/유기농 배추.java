import java.util.*;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static int[] answer;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        answer = new int[num];

        for(int i=0; i<num; i++){
            int m = scanner.nextInt(); //가로
            int n = scanner.nextInt(); //세로
            int k = scanner.nextInt();

            map = new int[n][m];
            visited = new boolean[n][m];

            for(int j=0; j<k; j++){
                int col = scanner.nextInt(); //열
                int row = scanner.nextInt(); //행
                map[row][col] = 1;
            }

            /*
            for(int[] y:map){
                for(int x:y){
                    System.out.print(x+ " ");
                }
                System.out.println();
            }
            */


            for(int l=0; l<n; l++){
                for(int o=0; o<m; o++){
                    if(map[l][o]==1 && !visited[l][o]){
                        visited[l][o]=true;
                        dfs(l,o,m,n);
                        answer[i]++;
                    }
                }
            }

        }
        for(int a:answer){
            System.out.println(a);
        }


    }
    static void dfs(int row, int col, int m, int n){
        for(int i=0; i<4; i++){
            int nx = row + dx[i];
            int ny = col + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m){
                //System.out.println(nx+","+ny);
                if(map[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    dfs(nx,ny,m,n);
                }
            }
        }
    }
}
