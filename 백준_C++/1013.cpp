#include <bits/stdc++.h>
using namespace std;

int main(){
    int t;
    string ans;
    vector<int> a;
    cout<<a.size()<<endl;
    cin>>t;
    for(int p=0;p<t;p++){
        string a;
        cin>>a;

        vector<int> dp(a.length(),0);
        if(a[0] == '0'){
            dp[0] = 6;
        }else{
            dp[0] = 1;
        }
        for(int i=1;i<a.length();i++){
            if(dp[i-1]==1 && a.at(i) == '0'){
                dp[i] = 2;
            }else if(dp[i-1] == 2 && a.at(i) == '0'){
                dp[i] = 3;
            }else if(dp[i-1] == 3 && a.at(i) == '0'){
                dp[i] = 3;
            }else if(dp[i-1] == 3 && a.at(i) == '1'){
                dp[i] = 4;
            }else if(dp[i-1] == 4 && a.at(i) == '1'){
                dp[i] = 5;
            }else if(dp[i-1] == 4 && a.at(i) == '0'){
                dp[i] = 6;
            }else if(dp[i-1] == 5 && a.at(i) == '1'){
                dp[i] = 5;
            }else if(dp[i-1] == 5 && a.at(i) == '0'){
                dp[i] = 9;
            }else if(dp[i-1] == 6 && a.at(i) == '1'){
                dp[i] = 7;
            }else if(dp[i-1] == 7 && a.at(i) == '0'){
                dp[i] = 6;
            }else if(dp[i-1] == 7 && a.at(i) == '1'){
                dp[i] = 1;
            }else if(dp[i-1] == 9 && a.at(i) == '0'){
                dp[i] = 3;
            }else if(dp[i-1] == 9 && a.at(i) == '1'){
                dp[i] = 7;
            }else{
                ans = "NO";
                break;
            }
       }
       if(dp.back() == 4 || dp.back() == 5 || dp.back() == 7){
           ans = "YES";
       }else{
           ans = "NO";
       }
       cout<<ans<<endl;
    }
}