#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    long long result = 0;
    cin>>n;

    vector< vector<long long> >dp(n+1,vector<long long>(10,0));

    for(int i=1;i<10; i++){
        dp[1][i] = 1;
    }

    for(int i=2;i<=n;i++){
        for(int j=0;j<10;j++){
            if(j == 0){
                dp[i][j] = dp[i-1][1] % 1000000000;
            }else if(j == 9){
                dp[i][j] = dp[i-1][8] % 1000000000;
            }else{
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])% 1000000000;
            }
        }
    }

    for(int i=0;i<10;i++){
        result = (result + dp[n][i] )% 1000000000;
    }
    cout<<result<<endl;
}