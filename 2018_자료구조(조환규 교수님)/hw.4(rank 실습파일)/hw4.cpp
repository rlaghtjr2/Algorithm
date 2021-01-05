#include <bits/stdc++.h>
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
using namespace std;
int N,score,i,m,scorenumber,k,r,bro;
int main(){
    ifstream instream("rank.inp"); //in파일 불러오기
    instream>>N;
    vector< vector<double> > sum(N, vector<double> (6,0));
    vector< vector<double> > rank(N, vector<double> (30,0));
    for(i=0;i<N;i++){
        sum[i][2]=i+1;
    }
    for(i=0;i<N;i++){
        scorenumber=0;
        for(m=0;m<30;m++){
            instream>>score;
            if(score>=0){
                rank[i][m]=score;
                scorenumber++;
            }
            else    break;
            }
        sum[i][1]=scorenumber;}
    for(i=0;i<N;i++){
        sort(rank[i].rbegin(),rank[i].rend());
        rank[i].resize(sum[i][1],0);
        sort(rank[i].begin(),rank[i].end());
    }
    instream.close();
    ofstream outstream;
    outstream.open("rank.out");
    for(i=0;i<N;i++){
        r=100;
        sum[i][0]=sum[i][1]*10000000;
        sum[i][0]=sum[i][0]+rank[i][0]*1000000;
        sum[i][0]=sum[i][0]+(1/sum[i][2]);
    }
    for(i=0;i<N;i++){
        r=100000;
        for(m=1;m<30;m++){
            sum[i][0]=sum[i][0]+rank[i][m]*r;
            r=r/10;
        }
    }
    sort(sum.rbegin(),sum.rend());
    for(i=0;i<N;i++){
        outstream<<sum[i][2]<<"\n";
    }
    outstream.close();//출력파일 닫기
}
