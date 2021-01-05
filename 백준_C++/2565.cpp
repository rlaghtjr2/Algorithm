#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector< vector<int> > elec(n+1,vector<int>(0,0));
    vector<int> dp(1,0);

    for(int i=0;i<n;i++){
        int a,b;
        cin>>a>>b;
        elec[i+1].push_back(a);
        elec[i+1].push_back(b);
    }

    sort(elec.begin(),elec.end());

    for(int i=1;i<n+1;i++){
        int dpSize = dp.size();
        if(elec[i][1] > dp[dpSize-1]){
            dp.push_back(elec[i][1]);
        }else if(elec[i][1] < dp[dpSize-1]){
            for(int j=0;j<dpSize-1;j++){
                if(elec[i][1]>dp[j] && elec[i][1] < dp[j+1]){
                    dp[j+1] = elec[i][1];
                }
            }
        }
    }

    cout<<n - (dp.size()-1)<<endl;
}