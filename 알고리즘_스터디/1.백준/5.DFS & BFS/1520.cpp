#include <bits/stdc++.h>

using namespace std;
int maps[500][500];
// bool check[500][500];
int ans[500][500];
int m,n;
int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};

int dfs(int y, int x){
    bool flag = false;
    if(y==m-1 && x==n-1) return 1;
    if(ans[y][x] != -1) return ans[y][x];

    ans[y][x] = 0;

    for(int i=0;i<4;i++){
        int nextY = y+dy[i];
        int nextX = x+dx[i];

        if(nextY>=m || nextY<0 || nextX >=n || nextX<0) continue;
        if(maps[nextY][nextX]>=maps[y][x]) continue;
        
        ans[y][x] += dfs(nextY,nextX);
    }
    return ans[y][x];
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin>>m>>n;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            cin>>maps[i][j];
            ans[i][j] = -1;
        }
    }
    cout<<dfs(0,0)<<endl;

}