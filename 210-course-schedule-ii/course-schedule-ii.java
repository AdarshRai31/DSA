class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int k = 0;
        int[] ans = new int[numCourses];

        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            ans[k++] = curr;

            for (int i = 0; i < graph[curr].size(); i++) {
                int next = graph[curr].get(i);
                if (--inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (k != numCourses) {
            return new int[0];
        }

        return ans;
    }
}