#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int> line(n);
    vector<int> ans;
    for(int i=0;i<n;i++){
        cin>>line[i];
    }

    ans.push_back(n);
    
    for(int i=n-2;i>=0;i--){
        vector<int>::iterator it = ans.begin();
        ans.insert(it+line[i],i+1);
    }

    for(int i=0;i<n;i++){
        cout<<ans[i]<<" ";
    }
}