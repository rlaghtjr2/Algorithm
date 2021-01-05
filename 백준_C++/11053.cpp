#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int> vec;
    vector<int> dp(1,0);
    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        vec.push_back(a);
    }

    for(int i=0;i<n;i++){
        int dpSize = dp.size();

        if(vec[i]>dp[dpSize-1]){
            dp.push_back(vec[i]);
        }else if(vec[i]<dp[dpSize-1]){
            for(int j=0;j<dpSize-1;j++){
                if(dp[j]<vec[i] && dp[j+1] > vec[i]){
                    dp[j+1] = vec[i];
                    break;
                }
            }
        }
    }

    cout<<dp.size()-1<<endl;
}