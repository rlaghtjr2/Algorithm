#include <bits/stdc++.h>
using namespace std;
int answer = 64;
int n,m;
int func(int a,int b, vector< vector<char> >&board){
    int white = 0;
    int black = 0;
    for(int i=a;i<a+8;i++){
        for(int j=b;j<b+8;j++){
            //처음 하얀색 
            if((i+j)%2 == 0 && board[i][j] != 'W'){
                white++;      
            }else if((i+j)%2 == 1 && board[i][j] != 'B'){
                white++;
            }
            //처음 검은색
            if((i+j)%2 == 0 && board[i][j] != 'B'){
                black++;      
            }else if((i+j)%2 == 1 && board[i][j] != 'W'){
                black++;
            }

            //둘다 현재answer보다 넘을경우 break
            if(white>= answer && black>= answer){
                break;
            }
        }
        //둘다 현재answer보다 넘을경우 break
        if(white>=answer && black>= answer){
            break;
        }
    }
    //black과 white중 하나라도 현재답보다 작으면 작은것 return
    if(black<answer || white<answer){
        if(black>white){
            return white;
        }else{
            return black;
        }
    }
    //둘다 현재답보다 크면 -1 return
    return -1;
}
int main(){
    cin>>n>>m;
    vector< vector<char> >board(n,vector<char>(m));
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            scanf("%1s", &board[i][j]);
        }
    }

    for(int i=0;i<=n-8;i++){
        for(int j=0;j<=m-8;j++){
            //return값 받음
            int b = func(i,j,board);
            // -1이 아닐경우 ( 현재값보다 작은경우 ) 답을 현재답으로 고침
            if(b != -1){
                answer = b;
            }
        }
    }
    cout<<answer<<endl;
}