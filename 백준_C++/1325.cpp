#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,m;
    int max = 0;
    cin>>n>>m;
    
    vector< vector<int> >node(n+1,vector<int>(0,0));
    vector<int> result;
    for(int i=0;i<m;i++){
        int a,b;
        cin>>a>>b;
        node[b].push_back(a);
    }

    for(int i=1;i<n+1;i++){
        int counting = 0;
        stack<int> dfs;
        vector<bool> check(n+1,false);
        dfs.push(i);
        while(!dfs.empty()){
            int element = dfs.top();
            dfs.pop();
            if(check[element]){
                continue;
            }else{
                counting++;
                check[element]=true;
                for(int j=0;j<node[element].size();j++){
                    dfs.push(node[element][j]);
                }
            }
        }
        if(counting>max){
                result.clear();
                result.push_back(i);
                max = counting;
        }else if(counting==max){
            result.push_back(i);
        }else{
            continue;
        }
    }
    sort(result.begin(),result.end());
    for(int i=0;i<result.size();i++){
         cout<<result[i]<<" ";
     }
}