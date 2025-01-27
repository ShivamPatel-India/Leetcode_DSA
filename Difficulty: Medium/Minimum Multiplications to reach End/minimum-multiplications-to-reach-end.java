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
    class Pair {
        int number;
        int step;
        Pair(int n, int s) {
            this.number = n;
            this.step = s;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        
        int[] dist = new int[100000];
        for(int i = 0; i < 100000; i++) {
            dist[i] = (int)1e9;
        }
        dist[start] = 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        
        int mod = 100000;
        int n = arr.length;
        
        while(!q.isEmpty()) {
            int num = q.peek().number;
            int step = q.peek().step;
            q.remove();
            
            for(int i = 0; i < n; i++) {
                int newNum = (num * arr[i]) % mod;
                int newStep = step + 1;
                
                if(newStep < dist[newNum]) {
                    dist[newNum] = newStep;
                    if(newNum == end) return newStep;
                    q.add(new Pair(newNum, newStep));
                }
            }
        }
        return -1;
    }
}
