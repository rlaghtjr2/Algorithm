#include <bits/stdc++.h>

using namespace std;
int R,C,N;
int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};
void bfs(vector< vector< pair<char,int> > >&maps){
    int time = 3;
    while(time<=N){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
               if(maps[i][j].second == time){
                   for(int k=0;k<4;k++){
                       if(i+dy[k]>=R || i+dy[k]<0 || j+dx[k]>=C || j+dx[k]<0) continue;
                        if(maps[i+dy[k]][j+dx[k]].second == time) continue;
                        maps[i+dy[k]][j+dx[k]] = make_pair('O',time+4);
                   }
                   maps[i][j].second = time+4;
               }else{
                   if(maps[i][j].second!=time+4) maps[i][j] = make_pair('O',time+2);
               }
            }
        }
        time+=2;
    }
}
int main(){
    cin>>R>>C>>N;

    vector< vector< pair<char,int> > >maps(R,vector< pair<char,int> >(C));

    for(int i=0;i<R;i++){
        for(int j=0;j<C;j++){
            char c;
            cin>>c;
            if(c=='O') maps[i][j] = make_pair(c,3);
            else maps[i][j] = make_pair(c,5);
        }
    }
    
    if(N%2==0){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                cout<<"O";
            }
            cout<<endl;
        }
    }else{
        bfs(maps);
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(maps[i][j].second==N+4) cout<<".";
                else cout<<"O";
            }
            cout<<endl;
        }
    }
}

