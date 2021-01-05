#include <bits/stdc++.h>
using namespace std;

int main(){
    int answer = 0;
    int n,m;
    cin>>n>>m;
    int minPack = 1001;
    int minPiece = 1001;
    int six;
    for(int i=0;i<m;i++){
        int a,b;
        cin>>a>>b;
        if(minPack>a){
            minPack = a;
        }

        if(minPiece>b){
            minPiece = b;
        }
    }

    if(minPack>minPiece*6){
        six = minPiece*6;
    }else{
        six = minPack;
    }

    while(n>6){
        answer = answer + six;
        n=n-6;
    }

    if(minPack>minPiece*n){
        answer = answer + minPiece*n;
    }else{
        answer = answer + minPack;
    }

    cout<<answer<<endl;
}