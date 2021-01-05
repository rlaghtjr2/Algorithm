#include <bits/stdc++.h>
using namespace std;
int max(int a, int b){
    if(a>b){
        return a;
    }else{
        return b;
    }
}
int main(){
    int n;
    cin>>n;
    vector<int> dp(n,0);
    vector<int> input;

    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        input.push_back(a);
    } 

    dp[0] = input[0];
    for(int i=1;i<n;i++){
        dp[i] = max(dp[i-1]+input[i],input[i]);
    }
    sort(dp.rbegin(),dp.rend());
    cout<<dp[0]<<endl;
}