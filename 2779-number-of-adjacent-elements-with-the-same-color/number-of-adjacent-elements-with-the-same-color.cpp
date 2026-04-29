class Solution {
public:
    vector<int> colorTheArray(int n, vector<vector<int>>& queries) {
        // set<int> s;
        int count = 0;
        vector<int> color(n, 0);
        vector<int> res;
        for (auto row : queries) {
            int idx = row[0];
            if (color[idx] != 0) {
                if (idx > 0 && color[idx] == color[idx - 1]) count--;
                if (idx < n - 1 && color[idx] == color[idx + 1]) count--;
            }

            color[idx] = row[1];

            if (idx > 0 && color[idx] == color[idx - 1]) count++;
            if (idx < n - 1 && color[idx] == color[idx + 1]) count++;

            res.push_back(count);
        }
        return res;
    }
};