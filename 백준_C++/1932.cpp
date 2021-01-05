#include <bits/stdc++.h>
using namespace std;
int max(int a,int b){
    if(a>b){
        return a;
    }else{
        return b;
    }
}

int main(){
    int n;
    int result = 0;
    cin>>n;

    vector< vector<int> > tri(n,vector<int>(0,0));
    vector< vector<int> > ans(n,vector<int>(n,0));
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            int a;
            cin>>a;
            tri[i].push_back(a);
        }
    }
    
    ans[0][0] = tri[0][0];

    for(int i=1;i<n;i++){
        for(int j=0;j<=i;j++){
            if(j==0){
                ans[i][j] = ans[i-1][j]+tri[i][j];
            }else if(j==i){
                ans[i][j] = ans[i-1][j-1]+tri[i][j];
            }else{
                ans[i][j] = max(ans[i-1][j]+tri[i][j],ans[i-1][j-1]+tri[i][j]);
            }
        }
    }
    
    for(int i=0;i<n;i++){
        if(ans[n-1][i]>result){
            result = ans[n-1][i];
        }
    }

    cout<<result<<endl;
}