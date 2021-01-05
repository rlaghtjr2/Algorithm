#include <bits/stdc++.h>
using namespace std;
int n,m;

bool removeIce(vector< vector<int> >&ice){
    bool isRunning = false;
    vector< vector<int> > compareIce;
    compareIce = ice;
    for(int i=1;i<n;i++){
        for(int j=1;j<m;j++){
            if(ice[i][j]>0){
                isRunning = true;
                if(i != n-1){
                    if(ice[i+1][j] == 0){
                        compareIce[i][j]--;
                    }
                }

                if( i != 0){
                    if(ice[i-1][j] == 0){
                        compareIce[i][j]--;
                    }
                }

                if(j != m-1){
                    if(ice[i][j+1] == 0){
                        compareIce[i][j]--;
                    }
                }

                if(j != 0){
                    if(ice[i][j-1] == 0){
                        compareIce[i][j]--;
                    }
                }

                if(compareIce[i][j]<0){
                    compareIce[i][j]=0;
                }
            }
        }
    }
    ice = compareIce;
    return isRunning;
}

int dfs(vector< vector<int> >ice){
    int result = 0;
    for(int i=1;i<n;i++){
        for(int j=1;j<m; j++){
            if(ice[i][j]!=0){
                stack< pair<int,int> > dfs;
                dfs.push(make_pair(i,j));

                while(!dfs.empty()){
                    int first = dfs.top().first;
                    int second = dfs.top().second;

                    ice[first][second] = 0;

                    dfs.pop();

                    if(first != n-1){
                        if(ice[first+1][second] != 0){
                            dfs.push(make_pair(first+1,second));
                        }
                    }

                    if(first != 0){
                        if(ice[first-1][second] != 0){
                            dfs.push(make_pair(first-1,second));
                        }
                    }

                    if(second != m-1){
                        if(ice[first][second+1] != 0){
                            dfs.push(make_pair(first,second+1));
                        }
                    }

                    if(second != 0){
                        if(ice[first][second-1] !=0){
                            dfs.push(make_pair(first,second-1));
                        }
                    }
                }
                result++;
            }
        }
    }
    return result;
}

int main(){
    cin>>n>>m;
    int result = 0;
    vector< vector<int> >ice(n, vector<int>(m,0));
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            int a;
            cin>>a;
            ice[i][j] = a;
        }
    }
    
    while(dfs(ice)<2){
        bool isRunning = removeIce(ice);
        if(!isRunning){
            result = 0;
            break;
        }
        result++;
    }
    cout<<result<<endl;
}