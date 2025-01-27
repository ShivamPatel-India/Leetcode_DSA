//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        
        int n = arr.length;
        int[] dist = new int[100000];
        for(int i = 0; i < 100000; i++) {
            dist[i] = (int)1e9;
        }
        dist[start] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        int mod = 100000;
        
        while(!q.isEmpty()) {
            int num = q.peek()[0];
            int steps = q.peek()[1];
            q.remove();
            
            for(int i = 0; i < n; i++) {
                int newNum = (arr[i] * num) % mod;
                
                if(steps + 1 < dist[newNum]) {
                    dist[newNum] = steps + 1;
                    if(newNum == end) return steps + 1;
                    q.add(new int[]{newNum, steps + 1});
                }
            }
        }
        return -1;
    }
}
