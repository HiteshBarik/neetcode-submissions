class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preReq = new HashMap<>();
        for(int[] pair : prerequisites) {
            preReq.computeIfAbsent(pair[0], k -> new ArrayList<>())
            .add(pair[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for(int c = 0; c < numCourses; c++) {
            if(!dfs(c, preReq, visit, cycle, output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preReq, Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {
        if(cycle.contains(course)) {
            return false;
        }
        if(visit.contains(course)) {
            return true;
        }

        cycle.add(course);
        for(int pre: preReq.getOrDefault(course, Collections.emptyList())) {
            if(!dfs(pre, preReq, visit, cycle, output)) {
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}
