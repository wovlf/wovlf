import java.io.*;
import java.util.*;

public class Main {


    public static ArrayList<Game> [] list;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Game> queue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start_index = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        int [] a = new int[v + 1];
        boolean [] visited = new boolean[v + 1];
        for(int i = 1;i<=v;i++)
        {
            list[i] = new ArrayList<>();
            a[i] = Integer.MAX_VALUE;
        }
        a[start_index] = 0;
        Game game;
        for(int i = 1;i<=e;i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            game = new Game(y, w);
            list[x].add(game);
        }
        queue.add(new Game(start_index, 0));
        while(!queue.isEmpty())
        {
            int get = queue.remove().index;
            if(!visited[get])
            {
                for(Game i : list[get])
                {
                    a[i.index] = Math.min(a[i.index], a[get] + i.node);
                    queue.add(new Game(i.index, a[i.index]));
                }
                visited[get] = true;
            }
        }
        for(int i = 1;i<=v;i++)
        {
           if(a[i] == Integer.MAX_VALUE)
           {
               bw.write("INF"+"\n");
           }
           else
           {
               bw.write(a[i]+"\n");
           }
        }
        bw.close();

    }
}

class Game implements Comparable<Game>
{
    int index;
    int node;
    public Game(int index,int node)
    {
        this.index = index;
        this.node = node;
    }

    @Override
    public int compareTo(Game o) {
        if(this.node > o.node)
        return 1;
        else
        {
            return -1;
        }
    }
}
