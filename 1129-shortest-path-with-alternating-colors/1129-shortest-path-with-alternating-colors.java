class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] red:redEdges){
            adj.get(red[0]).add(new int[]{red[1],0}); // 0 - red color
        }
        for(int[] blue:blueEdges){
            adj.get(blue[0]).add(new int[]{blue[1],1}); // 1 - blue color
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist,-1);
        dist[0]=0;
        boolean[][] vis = new boolean[n][2];
        vis[0][0] = true;
        vis[0][1] = true;

        queue.add(new int[]{0,0,-1}); //currentPos,distance,color

        while(!queue.isEmpty()){
            int[] prev = queue.remove();
            int node = prev[0]; 
            int steps = prev[1];
            int prevColor = prev[2];

            for(int[] neighbour: adj.get(node)){
                int adjNode = neighbour[0];
                int color = neighbour[1];
                
                if(!vis[adjNode][color] && color != prevColor){
                    if(dist[adjNode] == -1){
                        dist[adjNode] = steps + 1;
                    }
                    vis[adjNode][color] = true;
                    queue.add(new int[]{adjNode, steps+1, color});
                }
            }
        }
        return dist;
    }
}