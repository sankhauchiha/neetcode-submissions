class MedianFinder {

    List<Integer> l;

    public MedianFinder() {
        this.l = new ArrayList<>();
    }
    
    public void addNum(int num) {
        this.l.add(num);
    }
    
    public double findMedian() {
        Collections.sort(this.l);
            int n = this.l.size();
            int m1 = this.l.get(n/2);
            if(n%2==0){
                int m2 = this.l.get(n/2-1);
                return (m1+m2)/(double)2;
            }
            return m1;
    }

}
