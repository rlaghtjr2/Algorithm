#include <bits/stdc++.h>

using namespace std;

int G;
int main(){
    bool flag = false;
    vector<int> nums;
    cin>>G;

    for(int i=1;i<G;i++){
        if(G%i == 0){
            nums.push_back(i);
        }
    }
    for(int i=1;i<G;i++){
        for(int j=0;j<nums.size();j++){
            if(i+nums[j]>G) break;
            if(nums[j]>=i) break;

            long long x = i;
            long long y = i-nums[j];

            if((x+y)*(x-y) > G) break;
            else if(((x+y)*(x-y))==G){
                flag = true;
                cout<<x<<endl;
            }
        }
    }
    if(!flag){
        cout<<-1<<endl;
    }
}