#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    int counting;
    cin>>n;
    vector<int> alchol(n,0);
    vector<vector<int>> ans(3, vector<int> (n,0));
    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        alchol[i]=a;
    }
    ans[0][0] = alchol[0];
    ans[1][0] = alchol[0];
    ans[2][0] = 0;
    ans[0][1] = alchol[1];
    ans[1][1] = alchol[0]+alchol[1];
    ans[2][1] = alchol[0];

    for(int i=2;i<n;i++){
        ans[0][i] = ans[2][i-1]+alchol[i];
        ans[1][i] = ans[0][i-1]+alchol[i];
        ans[2][i] = max(max(ans[0][i-1],ans[1][i-1]),ans[2][i-1]);
    }
    cout<<max(max(ans[0][n-1],ans[1][n-1]),ans[2][n-1]);
}
