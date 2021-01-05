#include <bits/stdc++.h>

using namespace std;
int n,m;
int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};

int dfs(vector< vector<char> >&war,int one, int two){
    char warrior = war[one][two];
    int result = 0;
    stack< pair<int,int> >dfsStk;
    dfsStk.push(make_pair(one,two));

    while(!dfsStk.empty()){
        int first = dfsStk.top().first;
        int second = dfsStk.top().second;

        dfsStk.pop();

        if(war[first][second]=='X'){
            continue;
        }else{
            result++;
        }

        for(int i=0;i<4;i++){
            if(first+dx[i]>=n||first+dx[i]<0||second+dy[i]>=m||second+dy[i]<0)
                continue;
            
            if(war[first+dx[i]][second+dy[i]] == warrior ){
                dfsStk.push(make_pair(first+dx[i],second+dy[i]));
            }
        }
        war[first][second]='X';
    }
    return result*result;
}

int main(){
    int white = 0;
    int blue = 0;
    cin>>m>>n;
    vector< vector<char> >war(n,vector<char>(m));
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>war[i][j];
        }
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(war[i][j]=='W'){
                white += dfs(war,i,j);
            }else if(war[i][j]=='B'){
                blue += dfs(war,i,j);
            }
        }
    }

    cout<<white<<" "<<blue<<endl;
}
