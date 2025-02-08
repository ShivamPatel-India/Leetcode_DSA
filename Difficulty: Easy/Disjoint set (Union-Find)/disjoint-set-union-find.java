//{ Driver Code Starts
import java.util.*;

class Disjoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = i;
            int k = sc.nextInt();
            GfG g = new GfG();
            for (int i = 0; i < k; i++) {
                String s = sc.next();
                if (s.equals("UNION")) {
                    int x = sc.nextInt();
                    int z = sc.nextInt();
                    g.unionSet(a, x, z);
                } else {
                    int x = sc.nextInt();
                    int parent = g.find(a, x);
                    System.out.print(parent + " ");
                }
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    
    int find(int par[], int x) {
        if(x==par[x]) return x;
        else return par[x] = find(par,par[x]);
    }

    void unionSet(int par[], int x, int z) {
        int[] rank = new int[par.length];
        
        // find the ultimate parents of x and z
        int ulp_x = find(par, x);
        int ulp_z = find(par, z);
        
        // if ultimate parent same => they are in the same set
        if(ulp_x == ulp_z) return;
        
        // when not in the same set and dont have the same rank
        if(rank[ulp_x] > rank[ulp_z]) {
            par[ulp_z] = ulp_x;
        } else if(rank[ulp_z] > rank[ulp_x]) {
            par[ulp_x] = ulp_z;
        } else {
            // have same rank
            par[ulp_x] = ulp_z;
            rank[ulp_z]++;
        }
    }
}
