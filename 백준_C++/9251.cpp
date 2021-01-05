#include <bits/stdc++.h>
using namespace std;
int max(int a, int b, int c){
    if(a>b){
        if(b>c){
            return a;
        }else{
            if(a>c){
                return a;
            }else{
                return c; 
            }
        }
    }else{ //b>a
        if(a>c){
            return b;
        }else{ 
            if(b>c){
                return b;
            }else{
                return c;
            }
        }
    }
}
int main(){
    string a,b;
    cin>>a>>b;
    vector< vector<int> > dp(a.length(),vector<int>(b.length(),0));

    if(b.at(0) == a.at(0)){
        dp[0][0] = 1;
    }
    for(int i=1;i<a.length();i++){
        if(b.at(0) == a.at(i) && dp[i-1][0] == 0){
            dp[i][0] = dp[i-1][0]+1;
        }else{
            dp[i][0] = dp[i-1][0];
        }
    }

    for(int i=1;i<b.length();i++){
        if(a.at(0) == b.at(i) && dp[0][i-1] == 0){
            dp[0][i] = dp[0][i-1]+1;
        }else{
            dp[0][i] = dp[0][i-1];
        }
    }

    for(int i=1;i<a.length();i++){
        for(int j=1;j<b.length();j++){
            if(a.at(i) == b.at(j)){
                dp[i][j] = dp[i-1][j-1] +1;
            }else{
                dp[i][j] = max(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]);
            }
        }
    }

    cout<<dp[a.length()-1][b.length()-1]<<endl;
}