#include <bits/stdc++.h>
using namespace std;

int main(){
    int c,n;
    cin>>c>>n;
    vector<int> ans;
    vector<int> dp(1500,-1);


    for(int i=0;i<n;i++){
        int a,b;
        cin>>a>>b;
        if(dp[b]==-1){
            dp[b] = a;
        }else{
            if(dp[b]>a){
                dp[b] = a;
            }
        }
    }   
    int count = 2;
    while(count!=1500){
        for(int j=1;j<=count/2;j++){
            int a = dp[j];
            int b = dp[count-j];
            if(a!=-1 && b!=-1){
                if(dp[count]==-1){
                    dp[count] = a+b;
                }else if(a+b<dp[count]){
                    dp[count] = a+b;
                }
            }
        }
        count++;
    }
    for(int i=c;i<1500;i++){
        if(dp[i]!=-1){
            ans.push_back(dp[i]);
        }
    }

    sort(ans.begin(),ans.end());
    cout<<ans[0]<<endl;

}