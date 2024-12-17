//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    class Item {
        int w;
        int v;
        Item(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        List<Item> items = new ArrayList<>();
        int n = val.size();
        for(int i = 0; i < n; i++) {
            items.add(new Item(val.get(i), wt.get(i)));
        }
        Collections.sort(items, new Comparator<Item>(){
            @Override
            public int compare(Item a, Item b) {
                double f1 = (double)a.v/a.w;
                double f2 = (double)b.v/b.w;
                if(f1<f2) return 1;
                return -1;
            }
        });
        double totalValues = 0.0;
        for(Item i: items) {
            if(i.w <= capacity) {
                capacity -= i.w;
                totalValues += i.v;
            } else {
                totalValues += (double)(i.v)/(double)(i.w) * (double)(capacity);
                capacity = 0;
                break;
            }
        }
        return totalValues;
    }
}