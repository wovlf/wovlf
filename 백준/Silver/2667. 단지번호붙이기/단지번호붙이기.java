import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static int n;
    public static int count;
    public static int [] getx = {-1, 1, 0, 0};
    public static int [] gety = {0, 0, -1, 1};
    public static boolean [][] visited;

    public static int [][] a;
    public static int BFS(int i, int j)
    {
        int sum = 0;
        Queue<Game> queue = new LinkedList<>();
        Game game = new Game(i,j);
        queue.add(game);
        visited[i][j] = true;
        while(!queue.isEmpty())
        {
            sum++;
            for(int k = 0;k<4;k++)
            {
                int x = queue.peek().x + getx[k];
                int y = queue.peek().y + gety[k];
                if(x >= 0 && y >= 0 && x < n && y < n) // 배열 범위를 넘어서지 않으며
                {
                    if(a[x][y] == 1 &&  !visited[x][y]) // 해당 칸이 이동할수 있는 칸이며, 아직 방문안한 배열일경우
                    {
                        visited[x][y] = true;
                        game = new Game(x, y);
                        queue.add(game);
                    }
                }
            }
            queue.remove();

        }
        count++;
        return sum;
    }
    public static void main (String[]args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        a = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0;i<n;i++)
        {
            String s = br.readLine();
            for(int j = 0;j<n;j++)
            {
                a[i][j] = Integer.parseInt(s.substring(j, j+1));
            }

        }
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(a[i][j] == 1 && !visited[i][j]) // 집이 존재하고 아직 방문하지않았다면?
                {
                   list.add(BFS(i,j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for(int i : list)
        {
            System.out.println(i);
        }
    }

}
class Game {
    public int x;
    public int y;
        public Game(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
}