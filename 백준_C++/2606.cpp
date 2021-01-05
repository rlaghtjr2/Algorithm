#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,m;
    int result = -1;

    cin>>n>>m;
    vector< vector<int> >computer(n+1,vector<int>(0,0));
    vector<bool> check(n+1,false);

    for(int i=0; i<m; i++){
        int a,b;
        cin>>a>>b;
        
        computer[a].push_back(b);
        computer[b].push_back(a);
    }

    stack<int> dfs;
    dfs.push(1);

    while(!dfs.empty()){
        int element = dfs.top();
        dfs.pop();

        if(!check[element]){
            check[element] = true;

            for(int i=0;i<computer[element].size();i++){
                if(!check[computer[element][i]]){
                    dfs.push(computer[element][i]);
                }
            }
            result++;
        }
    }

    cout<<result<<endl;
}