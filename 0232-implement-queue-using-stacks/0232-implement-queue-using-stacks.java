/*

// This is the first approach where push operation is more expensive. So this //approach can be used when dealing with so many pop or top operations.

class MyQueue {

    // using two stacks to implement queue data structure
    // For any push operation into queue;
    // 1st step: stack1 -> stack2; (take all the elements from s1 to s2);
    // 2nd step:  x --> stack1; (push the element into s1);
    // 3rd step: transfer back everything form s2 to s1 

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
*/


// This is the second aaproach where we made the push operation less expensive than pop and top.

class MyQueue {

    // using two stacks to implement queue data structure
    // For any push operation into queue;
    // 1st step: stack1 -> stack2; (take all the elements from s1 to s2);
    // 2nd step:  x --> stack1; (push the element into s1);
    // 3rd step: transfer back everything form s2 to s1 

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) s2.push(s1.pop());
            return s2.pop();
        } else return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) s2.push(s1.pop());
            return s2.peek();
        } else return s2.peek();
    }
    
    public boolean empty() {
        return ( s1.size() + s2.size() ) == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */