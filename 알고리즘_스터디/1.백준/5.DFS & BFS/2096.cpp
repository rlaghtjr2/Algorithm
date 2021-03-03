#include <bits/stdc++.h>

using namespace std;

int n;

int max(int a, int b){
    if(a>b){
        return a;
    }else{
        return b;
    }
}

int max(int a, int b, int c){
    if(a>b){
        if(a>c) return a;
        else return c;
    }else{
        if(c>b) return c;
        else return b;
    }
}
int min(int a, int b){
    if(a>b){
        return b;
    }else{
        return a;
    }
}

int min(int a, int b, int c){
    if(a>b){
        if(b>c) return c;
        else return b;
    }else{
        if(a>c) return c;
        else return a;
    }
}
int main(){
    cin>>n;
    vector<int>dp(6,0);
    vector<int> nums(3,0);
    for(int i=0;i<n;i++){
        vector<int>dp2 = dp;
        for(int i=0;i<3;i++){
            cin>>nums[i];
        }
        if(i==0){
            for(int j=0;j<6;j++){
                if(j<3) dp[j] = nums[j];
                else dp[j] = nums[j-3];
            }
        }else{
            dp[0] = max(dp2[0],dp2[1]) + nums[0];
            dp[1] = max(dp2[0],dp2[1],dp2[2]) + nums[1];
            dp[2] = max(dp2[1],dp2[2]) + nums[2];
            dp[3] = min(dp2[3],dp2[4]) + nums[0];
            dp[4] = min(dp2[3],dp2[4],dp2[5]) + nums[1];
            dp[5] = min(dp2[4],dp2[5]) + nums[2];
        }
    }
    int min = INT_MAX;
    int max = INT_MIN;
    for(int i=0;i<3;i++){
        if(max<dp[i]){
            max = dp[i];
        }
    }

    for(int i=3;i<6;i++){
        if(min>dp[i]){
            min = dp[i];
        }
    }
    cout<<max<<" "<<min<<endl;

}