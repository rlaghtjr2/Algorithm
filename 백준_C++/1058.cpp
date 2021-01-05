#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector< vector<char> >friends(n,vector<char>(n));
    vector<int> ans(n,0);
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>friends[i][j]; 
        }
    }

    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(friends[i][j]=='Y'){
                ans[i]++;
                ans[j]++;
            }else{
                for(int k=0;k<n;k++){
                    if(friends[k][i] == 'Y' && friends[k][j] == 'Y'){
                        ans[i]++;
                        ans[j]++;
                        break;
                    }
                }
            }
        }
    }

    sort(ans.rbegin(),ans.rend());
    cout<<ans[0]<<endl;
}