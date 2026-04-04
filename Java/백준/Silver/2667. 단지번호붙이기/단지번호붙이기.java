import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static int n;
    static int dangiCnt = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        visited= new boolean[n][n];
        map = new int[n][n];

        for(int i=0; i<n; i++){
            String line = scanner.next();
            for(int j=0; j<line.length(); j++){
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        

        /*
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        */


        int cnt = 0;

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    dfs(i,j);
                    list.add(dangiCnt);
                    dangiCnt=0;
                    cnt++;
                }
            }
        }
        Collections.sort(list);

        System.out.println(cnt);
        for(int num:list){
            System.out.println(num);
        }


    }

    static void dfs(int y,int x){
        dangiCnt++;
        visited[y][x]=true;

        for(int i=0; i<4; i++){
            int ny=dy[i]+y;
            int nx=dx[i]+x;
            if(ny>=0 && nx>=0 && ny<n && nx<n){
                if(map[ny][nx]==1 && !visited[ny][nx]){
                    //System.out.println(ny+","+nx);
                    dfs(ny,nx);
                }

            }

        }

    }



}
