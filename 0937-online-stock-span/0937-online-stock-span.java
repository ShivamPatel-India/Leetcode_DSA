class Pair{
    int price;
    int span;
    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

class StockSpanner {
    private Stack<Pair> st;
    
    public StockSpanner() {
       st = new Stack<>(); 
    }
    
    public int next(int price) {
        int span = 1;
        while(!st.isEmpty() && price >= st.peek().price) {
            span += st.pop().span;
        }
        st.push(new Pair(price, span));
        return st.peek().span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */