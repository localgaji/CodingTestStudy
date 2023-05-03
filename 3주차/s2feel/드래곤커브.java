import java.util.*; 


class Line{
    
    int x1;
    int y1; 
    int x2;
    int y2;
    int d; 
    
    public Line(int x1, int y1, int x2, int y2, int d){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2; 
        this.d = d; 
    }
    
    
    
}


public class Main {
    
    public static int N;
    public static ArrayList<Line> arr; 
    public static int[][] map; 
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};
    
    public static void dfs(int curr, int g){
        
        
        if(curr == g){
            return; 
        }
        
        int next = 0;
        
        if(curr == 0){
            next = 1;
        }else{
            next = (int)Math.pow(2, curr);
        }
        
        int pos = arr.size()-1;
        int currX = arr.get(arr.size()-1).x2;
        int currY = arr.get(arr.size()-1).y2;
        
        
        while(next!= 0){
            Line line = arr.get(pos--);
            
            int newD = (line.d+1)%4;
            
            int nextX = currX + dx[newD];
            int nextY = currY + dy[newD];
            map[nextX][nextY] = 1; 
            
            Line newLine = new Line(currX, currY, nextX, nextY, newD);
            arr.add(newLine);
            currX = nextX;
            currY = nextY;
            next--; 
        }
        
        
        
        dfs(curr+1, g);
        
        
        
        
    }
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int N=sc.nextInt();
      map = new int[110][110];
      int ans = 0; 
      
      for(int i=1; i<=N; i++){
          
          int x = sc.nextInt();
          int y = sc.nextInt();
          int d = sc.nextInt();
          int g = sc.nextInt();
          
          arr = new ArrayList<>();
          int nx = 0;
          int ny = 0; 
          
          nx = x + dx[d];
          ny = y + dy[d];
          map[x][y] = 1;
          map[nx][ny] = 1;
          arr.add(new Line(x, y, nx, ny, d));
          
          
          dfs(0, g);
          
      }
      
      for(int i=0; i<=99; i++){
          for(int j=0; j<=99; j++){
              if(map[j][i] == 1 && map[j+1][i] == 1 && map[j][i+1] == 1 && map[j+1][i+1] == 1){
                  ans++;
              }
          }
      }
      
      System.out.println(ans); 
      
    }
}
