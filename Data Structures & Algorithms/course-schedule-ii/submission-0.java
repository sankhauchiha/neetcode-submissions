class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inEdge = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
            adjList.add(new ArrayList<>());
        

        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adjList.get(pre).add(course);
            inEdge[course]++;
        }
      

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inEdge[i] == 0)
                q.add(i);
        }

        int ct = 0;
        int[] res = new int[numCourses];
        while (!q.isEmpty()){
            int node = q.remove();
            res[ct++] = node;
            for(int neighbour : adjList.get(node)){
                inEdge[neighbour]--;
                if(inEdge[neighbour] == 0)
                    q.add(neighbour);
            }
        }

        if(ct == numCourses) return res;
        return new int[0];
    }
}
