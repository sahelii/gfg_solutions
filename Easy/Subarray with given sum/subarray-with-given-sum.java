//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> l = new ArrayList<>();
        if(s == 0){
            l.add(-1);
            return l;
        }
        int sum = 0, start = 0, end = 0;
        int curr = 0, x=0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            while(sum>s){
                sum -= arr[start];
                start++;
            }
            if(sum == s)
            {
                x = 1;
                end = i;
                break;
            }
        }
        int k = end;
        sum = 0;
        for(int i=k; i>=0; i--){
            sum += arr[i];
            if(sum == s){
                l.add(i+1);
                break;
            }
        }
        if(x ==0){
            l.add(-1);
        }
        else{
            l.add(end+1);
        }
        return l;
    }
}