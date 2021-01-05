#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,m;
    cin>>n>>m;

    vector< vector<string> >map(n,vector<string>(m,""));
    vector<int> result;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            char a;
            cin>>a;
            map[i][j] = a;
        }
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(map[i][j]=="L"){
                vector< vector<string> >map2;
                map2 = map;
                int counting = 0;
                queue< pair<int,int> >bfs;
                bfs.push(make_pair(i,j));
                map2[i][j]="F";
                while(!bfs.empty()){
                    int queSize = bfs.size();
                    for(int k=0;k<queSize;k++){
                        int col = bfs.front().first;
                        int row = bfs.front().second;
                        bfs.pop();

                        if(col != n-1){
                            if(map2[col+1][row] == "L"){
                                map2[col+1][row] = "F";
                                bfs.push(make_pair(col+1,row));
                            }
                        }
                        if(col != 0){
                            if(map2[col-1][row] == "L"){
                                map2[col-1][row] = "F";
                                bfs.push(make_pair(col-1,row));
                            }
                        }
                        if(row != m-1){
                            if(map2[col][row+1] == "L"){
                                map2[col][row+1] = "F";
                                bfs.push(make_pair(col,row+1));
                            }
                        }
                        if(row != 0){
                            if(map2[col][row-1] == "L"){
                                map2[col][row-1] = "F";
                                bfs.push(make_pair(col,row-1));
                            }
                        }
                    }
                    counting++;
                }
                result.push_back(counting-1);
            }
        }
    }
    sort(result.rbegin(),result.rend());
    cout<<result[0]<<endl;
}