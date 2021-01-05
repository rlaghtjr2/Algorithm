#include <bits/stdc++.h>
using namespace std;
int n;
int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};
vector<double> pr;
vector< vector<bool> >robotMap(29,vector<bool>(29));
double r=0;
void dfs(int first, int second, double result, int count){
    double plusResult = result;
    count++;
    robotMap[first][second] = true;
    if(count==n){
        r=r+result;
    }else{
        for(int i=0;i<4;i++){
            if(first+dx[i]>=n*2+1 || first+dx[i]<0 || second+dy[i]>=n*2+1 || second+dy[i]<0)
                continue;
            if(robotMap[first+dx[i]][second+dy[i]])
                continue;
            dfs(first+dx[i],second+dy[i],plusResult*pr[i],count);           
        }
    }
    robotMap[first][second] = false;
}
int main(){
    double result = 0;
    cin>>n;

    for(int i=0;i<4;i++){
        double p;
        cin>>p;
        pr.push_back(p/100);
    }

    robotMap[n][n] = true;

    for(int i=0;i<4;i++){
        dfs(n+dx[i],n+dy[i],pr[i],0);
    }
    cout.precision(11);
    cout<<r<<endl;
}