class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        int len = nums.size();
        long long total = (long long)len*((long long)len-1)/2;
        unordered_map<int,int>mpp;
        for(int i=0;i<len;++i){
            mpp[i-nums[i]]++;
        }
        long long good=0;
        for(auto it=mpp.begin();it!=mpp.end();++it){
            int cur = it->second;
            good+=((long long)cur*((long long)cur-1)/2);
        }
        return total-good;
    }
};