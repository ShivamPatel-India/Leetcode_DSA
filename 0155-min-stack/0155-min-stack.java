// Optimal approach

class MinStack {
    Stack<Long> st = new Stack<>();
    Long min;

    public MinStack() {
        min = Long.MAX_VALUE;
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);

        if(st.isEmpty()) {
            st.push(val);
            min = val;
        } else {
            if(val < min) {
                st.push(2*val - min);
                min = val;
            } else {
                st.push(val);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;

        Long val = st.pop();

        if(val < min) {
            min = 2 * min - val;
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;

        Long val = st.peek();
        if(val < min) return min.intValue();
        else return val.intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/* The solution given below requires an extra space of O(2N) bcz we are using Pairs.

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MinStack {

    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        int min;
        if(st.isEmpty()) min = val;
        else min = Math.min(val, st.peek().y);
        st.push(new Pair(val, min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().x;
    }
    
    public int getMin() {
        return st.peek().y;
    }
}
*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */