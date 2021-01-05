#include <bits/stdc++.h>
using namespace std;
int min(int a, int b){
    if(a>b){
        return b;
    }else{
        return a;
    }
}
int main(){
    int n;
    cin>>n;
    int count = 2;
    vector<int> sum;
    vector<int> tet;
    vector<int> dp(n+1,0);

    sum.push_back(1);
    tet.push_back(1);
    while(true){
        sum.push_back((count*(2+(count-1)))/2);
        tet.push_back(tet.back()+sum.back());
        if(tet.back()>n){
            tet.pop_back();
            break;
        }else if(tet.back()==n){
            break;
        }
        count++;
    }

    int first = tet[0];
    int counting = 0;
    for(int i=0;i<tet.size();i++){
        for(int j=tet[i];j<=n;j++){
            if(i==0){
                dp[j] = dp[j-1]+1;
            }else{
               dp[j] = min(dp[j-tet[i]]+1,dp[j]);
            }
        }
    }
   
    cout<<dp[n]<<endl;
}