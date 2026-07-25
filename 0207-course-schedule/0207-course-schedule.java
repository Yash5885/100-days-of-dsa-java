import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int completedCourses = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;

            for (int nextCourse : graph.get(current)) {
                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        return completedCourses == numCourses;
    }
}