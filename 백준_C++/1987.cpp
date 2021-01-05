#include <bits/stdc++.h>
using namespace std;
int R,C;
int result = 0;
vector<bool> check(26,0);
void dfs(vector< vector<char> >&board,int first, int second,int depth){
    if(depth>result){
        result = depth;
    }
    if(result==26){
        return;
    }
    if(first +1 != R){
        if(!check[ board[first+1][second] - 'A']){
            check[ board[first+1][second] - 'A'] = true;
            dfs(board,first+1,second,depth+1) ;
            if(result == 26){
                return;
            }
        }
    }
    if(first -1 != -1){
        if(!check[ board[first-1][second] - 'A']){
            check[ board[first-1][second] - 'A'] = true;
            dfs(board,first-1,second,depth+1);
            if(result == 26){
                return;
            }
        }
    }
    if(second +1 != C){
        if(!check[ board[first][second+1] - 'A']){
            check[ board[first][second+1] - 'A'] = true;
            dfs(board,first,second+1,depth+1);
            if(result == 26){
                return;
            }
        }
    }
    if(second -1 != -1){
        if(!check[ board[first][second-1] - 'A']){
            check[ board[first][second-1] - 'A'] = true;
            dfs(board,first,second-1,depth+1);
            if(result == 26){
                return;
            }
        }
    }

    check[ board[first][second] - 'A'] = false;
    return;
}
int main(){
    
    cin>>R>>C;
    vector< vector<char> >board(R, vector<char>(C,' '));

    for(int i=0;i<R;i++){
        string a;
        cin>>a;
        for(int j=0;j<C;j++){
            board[i][j] = a.at(j);
        }
    }

    check[ board[0][0] - 'A' ] = true;
    dfs(board,0,0,1);
    cout<<result<<endl;
}