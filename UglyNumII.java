//Time Complexity : O(N log N)
//Space Complexity : O(N)
class UglyNumII {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        long currUglyNum = 1;
        int[] primes = {2,3,5};
        pq.add(currUglyNum);
        set.add(currUglyNum);
        while(n != 0) {
            n--;
            currUglyNum = pq.poll();
            for(int pr : primes) {
                long newUglyNum = currUglyNum * pr;
                if(!set.contains(newUglyNum)) {
                    set.add(newUglyNum);
                    pq.add(newUglyNum);
                } 
            }
        }
        return (int)currUglyNum;

    }
}