import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class shh_17204 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int k = Integer.parseInt(strArr[1]);

        int[] lis = new int[n];
        for(int i=0; i<n;i++){
            int num1 = Integer.parseInt(br.readLine());
            lis[i] = num1;
        }
        Boolean bol = false;
        int count = 0;
        int target = 0;
        
        for(int i=0; i<n;i++){
            target = lis[target];
            count += 1;
            if(target==k){
                bol = true;
                break;
            }
        }
        if(bol) System.out.println(count);
        else System.out.println(-1);
    }
}