#include <bits/stdc++.h>
using namespace std;
int n,parent,deleteNode;
int result = 0;
int main(){
    stack<int> dfs;
    cin>>n;
    vector< vector<int> > node(n,vector<int>(0,0));
    for(int i=0;i<n;i++){
       int a;
       cin>>a;

       if(a==-1){
           parent = i;
       }else{
           node[a].push_back(i);
       }
    }
    cin>>deleteNode;

    dfs.push(deleteNode);
    for(int i=0;i<n;i++){
        for(int j=0;j<node[i].size();j++){
            if(node[i][j] == deleteNode && node[i].size() == 1){
                node[i].clear();
                break;
            }
        }
    }
    while(!dfs.empty()){
        int currentNode = dfs.top();
        dfs.pop();

        for(int i=0;i<node[currentNode].size();i++){
            dfs.push(node[currentNode][i]);
        }
        node[currentNode].clear();
        node[currentNode].push_back(-2);
    }
    for(int i=0;i<n;i++){
        if(node[i].empty()){
            result++;
        }
    }
    
    cout<<result<<endl;


}