public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] max = new int[nums.length-(k-1)];
        int idx = 0;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<k; i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.pollLast();
            
            queue.offer(i);
        }
        
        for(int i=0; i<max.length; i++){
            max[i] = nums[queue.peekFirst()];
            
            if(queue.peekFirst() == i)
                queue.pollFirst();
            
            while(!queue.isEmpty() && (i+k)<nums.length && nums[queue.peekLast()] < nums[i+k])
                queue.pollLast();
            
            if((i+k)<nums.length)
                queue.offer(i+k);
        }
        
        return max;
    }
