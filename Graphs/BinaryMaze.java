import java.io.File;
import java.util.Scanner;

public class BinaryMaze {
    private static class Point{
        int r, c;
        public Point(int r_, int c_){ r = r_; c = c_; }
        public boolean equals(Point o) { return r == o.r && c == o.c; }
        public String toString() { return "[" + r + ", " + c + "]"; }
    }

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(new File("maze.dat"));

        maze = new int[in.nextInt()][in.nextInt()];
        int pc = in.nextInt();

        for(int r = 0; r < maze.length; r++){
            for(int c = 0; c < maze[0].length; c++){
                maze[r][c] = in.nextInt();
            }
        }

        Point[][] paths = new Point[pc][2];
        for(int i = 0; i < pc; i++){
            paths[i][0] = new Point(in.nextInt(), in.nextInt());
            paths[i][1] = new Point(in.nextInt(), in.nextInt());
        }
        
        //tooo lazy to learn djikstra
        for(int p = 0; p < paths.length; p++){
            start = paths[p][0];
            end = paths[p][1];
            maze_vis = new boolean[maze.length][maze[0].length];
            
            // System.out.println(start + " | " + end);

            System.out.println(search(start, 0)  + "\n");
        }
    }

    private static int[][] maze;
    private static boolean[][] maze_vis;
    private static Point start;
    private static Point end;

    public static int search(Point cur, int moves){
        if(cur.equals(end)){
            maze_vis[cur.r][cur.c] = false;
            return moves;
        }
        maze_vis[cur.r][cur.c] = true;
        Point[] p = new Point[4];
        int pi = 0;
        for(int r = cur.r-1; r <= cur.r+1; r++){
            for(int c = cur.c-1; c <= cur.c+1; c++){
                //wall 
                if(r == cur.r && c == cur.c) continue;
                if((r-cur.r == c-cur.c) || (r == cur.r+1 && c == cur.c-1) || (r == cur.r-1 && c == cur.c+1)) continue;
                if(!(r >= 0 && r < maze.length && c >= 0 && c < maze[0].length)) continue;
                if(maze[r][c] == 0) continue;
                
                p[pi++] = new Point(r, c);
            }
        }

        for(int i = 0; i < 4; i++){
            int si = i;
            double sd = dist(p[i], end);
            for(int j = i+1; j < 4; j++){
                if(dist(p[j], end) < sd){
                    si = j;
                    sd = dist(p[si], end);
                }
            }
            var tmp = p[si];
            p[si] = p[i];
            p[i] = tmp;
        }
        
        // System.out.println("cur: " + cur + " | " + Arrays.toString(p));

        int sh = -1;
        for(Point pnt : p){
            if(pnt == null) break;
            if(maze_vis[pnt.r][pnt.c]) continue;

            int path = search(pnt, moves+1);

            if(path > -1){
                if(sh == -1)
                    sh = path;
                else 
                    sh = Math.min(sh, path);
            }
        }
        
        // System.out.println("not possible from: " + cur);
        return sh;
    }

    private static double dist(Point p1, Point p2){
        if(p1 == null || p2 == null) return Integer.MAX_VALUE;
        return Math.sqrt((p1.c-p2.c)*(p1.c-p2.c) + (p1.r-p2.r)*(p1.r-p2.r));
    }
}
