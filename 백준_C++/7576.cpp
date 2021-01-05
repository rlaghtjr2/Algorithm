#include <bits/stdc++.h>
using namespace std;
int main(){
    int m,n,a;
    cin>>m>>n;
    vector<vector<int>> tomato(n, vector<int> (m,0));
    queue<pair<int,int>> que;
    int day=0;
    bool isEmpty = true;
    bool allTomato = true;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>a;
            tomato[i][j] = a;
            if(a==1){
                que.push(make_pair(i,j));
            }else if(a==0){
                isEmpty=false;
            }
        }
    }


    if(isEmpty){
        cout<<0;
    }else{
        while(!que.empty()){
            int queSize = que.size();

            for(int i=0;i<queSize;i++){
                pair<int,int> a=que.front();
                int col = a.first;
                int row = a.second;
                que.pop();
                if(col==0){
                    if(tomato[col+1][row]==0){
                        tomato[col+1][row]=1;
                        que.push(make_pair(col+1,row));
                    }
                }else if(col==n-1){
                    if(tomato[col-1][row]==0){
                        tomato[col-1][row]=1;
                        que.push(make_pair(col-1,row));
                    }
                }else{
                    if(tomato[col+1][row]==0){
                        tomato[col+1][row]=1;
                        que.push(make_pair(col+1,row));
                    }
                    if(tomato[col-1][row]==0){
                        tomato[col-1][row]=1;
                        que.push(make_pair(col-1,row));
                    }
                }

                if(row==0){
                    if(tomato[col][row+1]==0){
                        tomato[col][row+1]=1;
                        que.push(make_pair(col,row+1));
                    }
                }else if(row==m-1){
                    if(tomato[col][row-1]==0){
                        tomato[col][row-1]=1;
                        que.push(make_pair(col,row-1));
                    }
                }else{
                    if(tomato[col][row+1]==0){
                        tomato[col][row+1]=1;
                        que.push(make_pair(col,row+1));
                    }
                    if(tomato[col][row-1]==0){
                        tomato[col][row-1]=1;
                        que.push(make_pair(col,row-1));
                    }
                }
            }
            day++;

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(tomato[i][j]==0){
                    allTomato = false;
                    break;
                }
            }
            if(!allTomato){
                break;
            }
        }
        if(!allTomato){
            cout<<-1;
        }else{
            cout<<day-1;
        }
    }

}
