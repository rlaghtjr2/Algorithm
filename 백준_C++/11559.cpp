#include <bits/stdc++.h>
using namespace std;
int result = 0;

void checkVector(vector< vector<char> >&puyo, int a, int b){
    vector< vector<bool> > isCheck(12,vector<bool>(6,0));
    int count = 0;
    queue< pair<int,int> > bfs;

    isCheck[a][b] = true;

    bfs.push(make_pair(a,b));
    while(!bfs.empty()){
        
        int first = bfs.front().first;
        int second = bfs.front().second;
        bfs.pop();

        if(first+1 != 12){
            if(puyo[first][second] == puyo[first+1][second] && !isCheck[first+1][second]){
                bfs.push(make_pair(first+1,second));
                isCheck[first+1][second] = true;
            }
        }
        if(first-1 != -1){
            if(puyo[first][second] == puyo[first-1][second] && !isCheck[first-1][second]){
                bfs.push(make_pair(first-1,second));
                isCheck[first-1][second] = true;
            }
        }
        if(second+1 != 6){
            if(puyo[first][second] == puyo[first][second+1] && !isCheck[first][second+1]){
                bfs.push(make_pair(first,second+1));
                isCheck[first][second+1] = true;
            }
        }
        if(second-1 != -1){
            if(puyo[first][second] == puyo[first][second-1] && !isCheck[first][second-1]){
                bfs.push(make_pair(first,second-1));
                isCheck[first][second-1] = true;
            }
        }
        count++;
    }
    if(count >=4){
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(isCheck[i][j]){
                    puyo[i][j] = '.';
                }
            }
        }
    }
}
void bfs(vector< vector<char> > &puyo){
    while(true){
        vector< vector<char> > compVec = puyo;
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(puyo[i][j]!='.'){
                    checkVector(puyo,i,j);       
                }
            }
        }
        for(int j=0;j<6;j++){
            for(int i=11;i>0;i--){
                if(puyo[i][j] == '.' && puyo[i-1][j] != '.'){
                    int first = i;
                    int second = j;
                    while(true){
                        puyo[first][second] = puyo[first-1][second];
                        puyo[first-1][j] = '.';
                        if(first+1 != 12 && puyo[first+1][second] == '.'){
                            first = first+1;
                        }else{
                            break;
                        }
                    }
            }
            }
        }
        if(compVec == puyo){
            break;
        }else{
            result++;
        }


    }
}


int main(){
    vector< vector<char> > puyo(12,vector<char>(6,' '));

    for(int i=0;i<12;i++){
        for(int j=0;j<6;j++){
            char a;
            cin>>a;
            puyo[i][j] = a;
        }
    }

    bfs(puyo);

    

    cout<<result<<endl;
}