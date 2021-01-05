#include <bits/stdc++.h>

using namespace std;
int n;

void dynamic(vector< vector<int> > &game, vector< vector<long long> >&dp){
    if(game[0][0]!=0){
        dp[0][0] = 1;
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            int distance = game[i][j];
            if(i==n-1 && j==n-1){
                break;
            }
            if(dp[i][j]!=0){
                if(i+distance<n){
                    dp[i+distance][j]=dp[i+distance][j] + dp[i][j];
                }

                if(j+distance<n){
                    dp[i][j+distance]=dp[i][j+distance] + dp[i][j];
                }
            }
        }
    }
}

int main(){
    cin>>n;
    vector< vector<int> >game(n,vector<int>(n,0));
    vector< vector<long long> >dp(n,vector<long long>(n,0));
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>game[i][j];
        }
    }
    dynamic(game,dp);
    cout<<dp[n-1][n-1];
}