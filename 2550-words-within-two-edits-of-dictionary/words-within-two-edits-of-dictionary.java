class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();

        for (String q : queries) {
            for (String s : dictionary) {
                int count = 0;
                for (int i = 0; i < q.length(); i++) {
                    if (s.charAt(i) != q.charAt(i)) {
                        count++;
                    }
                }
                if (count <= 2) {
                    res.add(q);
                    break;
                }
            }
        }

        return res;
    }
}