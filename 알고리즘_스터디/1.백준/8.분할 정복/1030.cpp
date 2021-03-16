#include <bits/stdc++.h>

using namespace std;

int s,N,K,R1,R2,C1,C2;

int quntum(int startY, int startX , int y,int x, int length){
    if(startY+length>y && y>=startY && startX+length>x && x>=startX){

    }else{
        int length2 = length * N;

    }
}
int main(){
    cin>>s>>N>>K>>R1>>R2>>C1>>C2;
    int length = (int)pow(N,s-1);
    
    for(int i=R1;i<=R2;i++){
        for(int j=C1;j<=C2;j++){
            quntum(0,0,i,j,length);
        }
    }
}