class Solution {
    private Set<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new HashSet<>();
        Arrays.sort(candidates);
        generateSubsets(candidates, target, 0, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }

    private void generateSubsets(int [] candidates, int target, int i, List <Integer> cur, int total) {
        if(total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(total > target || i == candidates.length) {
            return;
        }

        cur.add(candidates[i]);
        generateSubsets(candidates, target, i + 1, cur, total + candidates[i]);
        cur.remove(cur.size() - 1);

        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        generateSubsets(candidates, target, i + 1, cur, total);
    }
}
