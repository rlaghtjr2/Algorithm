#include <bits/stdc++.h>

using namespace std;
/*
문제
n*n의 크기의 대나무 숲이 있다. 욕심쟁이 판다는 어떤 지역에서 대나무를 먹기 시작한다. 그리고 그 곳의 대나무를 다 먹어 치우면 상, 하, 좌, 우 중 한 곳으로 이동을 한다. 그리고 또 그곳에서 대나무를 먹는다. 그런데 단 조건이 있다. 이 판다는 매우 욕심이 많아서 대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다. 만약에 그런 지점이 없으면 이 판다는 불만을 가지고 단식 투쟁을 하다가 죽게 된다(-_-)

이 판다의 사육사는 이런 판다를 대나무 숲에 풀어 놓아야 하는데, 어떤 지점에 처음에 풀어 놓아야 하고, 어떤 곳으로 이동을 시켜야 둘 다 소중한 생명이지만 판다가 최대한 오래 살 수 있는지 고민에 빠져 있다. 우리의 임무는 이 사육사를 도와주는 것이다. n*n 크기의 대나무 숲이 주어져 있을 때, 이 판다가 최대한 오래 살려면 어떤 경로를 통하여 움직여야 하는지 구하여라.

입력
첫째 줄에 대나무 숲의 크기 n(1 ≤ n ≤ 500)이 주어진다. 그리고 둘째 줄부터 n+1번째 줄까지 대나무 숲의 정보가 주어진다. 대나무 숲의 정보는 공백을 사이로 두고 각 지역의 대나무의 양이 정수 값으로 주어진다. 대나무의 양은 1,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에는 판다가 최대한 살 수 있는 일수(K)를 출력한다.
*/
int n;
int ans = INT_MIN;
int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};
int maps[500][500];
int dp[500][500];
int dfs(int first, int second){
    if(dp[first][second]!=0){
        return dp[first][second];
    }
    dp[first][second]=1;
    for(int i=0;i<4;i++){
        int y = first+dy[i];
        int x = second+dx[i];

        if(y>=n || y<0 || x>=n || x<0) continue;

        if(maps[y][x]>maps[first][second]){
            dp[first][second] = max(dp[first][second],1+dfs(y,x));
        }
    }
    ans = max(ans,dp[first][second]);
    return dp[first][second];
}

int main(){
    cin>>n;

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>maps[i][j];
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            dfs(i,j);
        }
    }
    cout<<ans<<endl;
}

/*
4
16 15 14 13
9 10 11 12
8 7 6 5
1 2 3 4
*/