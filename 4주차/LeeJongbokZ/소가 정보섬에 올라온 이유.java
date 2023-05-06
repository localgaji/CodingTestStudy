// 1.왜 맞았는가?
// -> 간단한 구현 문제임
// -> 문제의 요구 사항대로 그대로 구현을 해줬음
// -> 다만, 코드가 좀 복잡한 것 같아서, 리팩토링을 하면 좋을 것 같음 

import java.util.*; 

public class Main {
    

    public static int[] arr; 
    
    
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int Q = sc.nextInt(); 
      
      arr = new int[N+10];
      
      for(int i=1; i<=N; i++){
          arr[i] = sc.nextInt();
      }
      
      arr[N+1] = arr[1];
      arr[N+2] = arr[2];
      arr[N+3] = arr[3];
      
      
      int sum = 0; 
      
      for(int i=1; i<=N; i++){
          sum += arr[i]*arr[i+1]*arr[i+2]*arr[i+3];
      }
      
      
      
      while(true){
          
          if(Q == 0){
              break; 
          }
          
          int pos = sc.nextInt();
          
          int tmp = 0;
          
          for(int i=0; i<4; i++){
              
              int a = (pos-i+N)%N;
              int b = (pos+1-i+N)%N;
              int c = (pos+2-i+N)%N;
              int d = (pos+3-i+N)%N;
              
              if(a == 0){
                  a += N;
              }else if(b == 0){
                  b += N;
              }else if(c == 0){
                  c += N;
              }else if(d == 0){
                  d += N; 
              }
              
              tmp += (arr[a]*arr[b]*arr[c]*arr[d]);
          }
          
          sum -= tmp; 
          
          if(pos == 1 || pos == 2 || pos == 3){
             arr[pos] = -1*arr[pos];
             arr[pos+N] = -1*arr[pos+N];
          }else{
             arr[pos] = -1*arr[pos];
          }
          
          int changedTmp = 0; 
          
          for(int i=0; i<4; i++){
              
              int a = (pos-i+N)%N;
              int b = (pos+1-i+N)%N;
              int c = (pos+2-i+N)%N;
              int d = (pos+3-i+N)%N;
              
              if(a == 0){
                  a += N;
              }else if(b == 0){
                  b += N;
              }else if(c == 0){
                  c += N;
              }else if(d == 0){
                  d += N; 
              }
              
              changedTmp += (arr[a]*arr[b]*arr[c]*arr[d]);
          }
          
          sum += changedTmp; 
          
          System.out.println(sum);
          
          Q--;
          
      }
      
      
      
      
      
      
    }
}
