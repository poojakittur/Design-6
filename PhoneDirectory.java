/*
 * Time complexity : O(1) for all operations
 * Space complexity : O(n)
 */
class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    
    Queue<Integer> queue;
    Set<Integer> set;
    public PhoneDirectory(int maxNumbers) {
        
        queue = new LinkedList<Integer>();
        set = new HashSet<>();
        
        for(int i=0; i< maxNumbers; i++){
            queue.add(i);
            set.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(queue.isEmpty()){
            return -1;
        }
        
        int x = queue.poll();
        set.remove(x);
        return x;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(!set.contains(number)){
            
            queue.add(number);
            set.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */