#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,m;
    int result = 0;
    bool isRunning = true;
    cin>>n>>m;
    vector< vector<int> >maze(n,vector<int>(m,0));

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            scanf("%1d", &maze[i][j]);
        }
    }

    queue< pair<int,int> > bfs;

    bfs.push(make_pair(0,0));

    while(!bfs.empty() && isRunning){
        int queSize = bfs.size();

        for(int i=0;i<queSize;i++){
            pair<int,int> element = bfs.front();
            bfs.pop();

            if(element.first!=n-1){
                if(maze[element.first+1][element.second] == 1){
                    bfs.push(make_pair(element.first+1,element.second));
                    maze[element.first+1][element.second] = -1;
                    if(element.first+1 == n-1 && element.second == m-1){
                        isRunning = false;
                        break;
                    }
                }
            }

            if(element.first!=0){
                if(maze[element.first-1][element.second] == 1){
                    bfs.push(make_pair(element.first-1,element.second));
                    maze[element.first-1][element.second] = -1;
                    if(element.first-1 == n-1 && element.second == m-1){
                        isRunning = false;
                        break;
                    }
                }
            }

            if(element.second != m-1){
                if(maze[element.first][element.second+1] == 1){
                    bfs.push(make_pair(element.first,element.second+1));
                    maze[element.first][element.second+1];
                    if(element.first == n-1 && element.second+1 == m-1){
                        isRunning = false;
                        break;
                    }
                }
            }

            if(element.second != 0){
                if(maze[element.first][element.second-1] == 1){
                    bfs.push(make_pair(element.first,element.second-1));
                    maze[element.first][element.second-1] = -1; 
                    if(element.first == n-1 && element.second-1 == m-1){
                        isRunning = false;
                        break;
                    }
                }
            }
        }

        result++;
    }

    cout<<result+1<<endl;
}