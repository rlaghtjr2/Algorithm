#include <bits/stdc++.h>
using namespace std;
int n,m,v;
vector<int> dfsAnswer;
vector<int> bfsAnswer;

void dfs(vector< vector<int> > graph, int v){
    stack<int> dfs;
    vector<bool> check(n+1,false);

    dfs.push(v);

    while(!dfs.empty()){
        int element = dfs.top();
        dfs.pop();

        if(!check[element]){
            check[element] = true;

            for(int i=graph[element].size()-1;i>=0;i--){
                if(!check[graph[element][i]]){
                    dfs.push(graph[element][i]);
                }
            }
            dfsAnswer.push_back(element);            
        }
    }
}

void bfs(vector< vector<int> >graph, int v){
    queue<int> bfs;
    vector<bool> check(n+1,false);

    bfs.push(v);

    while(!bfs.empty()){
        int element = bfs.front();
        bfs.pop();

        if(!check[element]){
            check[element] = true;
            
            for(int i=0;i<graph[element].size();i++){
                if(!check[graph[element][i]]){
                    bfs.push(graph[element][i]);
                }
            }
            bfsAnswer.push_back(element);
        }
    }
}
int main(){
    cin>>n>>m>>v;
    vector< vector<int> >graph(n+1,vector<int>(0,0));
  
    for(int i=0;i<m;i++){
        int a,b;
        cin>>a>>b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    for(int i=1;i<n+1;i++){
        sort(graph[i].begin(),graph[i].end());
    }

    dfs(graph,v);
    bfs(graph,v);
    for(int i=0; i<dfsAnswer.size();i++){
        cout<<dfsAnswer[i]<<" ";
    }
    cout<<endl;
    for(int i=0;i<bfsAnswer.size();i++){
        cout<<bfsAnswer[i]<<" ";
    }
    cout<<endl;
}