// 1. 왜 맞았는가?
// -> DP로 접근할 수 있음을 고려해서, Memoization을 써야 한다.
// -> 이를 통해 시간 복잡도를 낮출 수 있다.
// -> 또한, 피보나치로 DP를 만들되 +1을 해줘야 한다.
// -> 왜냐하면 각각의 피보나치 함수에 접근하는 것이 1번의 호출을 만들어내기 때문이다. 

import java.util.*; 

public class Main {
    
    
    public static long ans; 
    public static long[] cnt;
    
    public static long fibonacci(int n){
        
        if(n < 2){
            cnt[n] = 1; 
            return cnt[n]; 
        }
        
        // System.out.println("n, cnt[n]" +  n + " " + cnt[n]);
        
        if(cnt[n] != 0){
            return cnt[n];
        }
        
        
        return cnt[n] = (fibonacci(n-2)+fibonacci(n-1)+1) % 1000000007;
        
        
        
        
    }
    
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt(); 
      cnt = new long[100];
      
      
      fibonacci(n);
      
      /*
      for(int i=1; i<=n; i++){
          System.out.print(cnt[i]+ " ");
      }
      */
      
      
      System.out.println(cnt[n]); 
      
    }
}
