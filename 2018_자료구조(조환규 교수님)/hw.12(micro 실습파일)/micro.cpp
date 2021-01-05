#include <bits/stdc++.h>
using namespace std;
int N,M,K,counting,x,y;
int number=0;
int maximum=0;
string a;
int main(){
    ifstream instream("micro.inp");
    ofstream outstream("micro.out");
    instream>>N>>M>>K;
    vector<vector<string>> micro(M,vector<string>(0));

    queue<int> xq;
    queue<int> yq;
    for(int i=0;i<M;i++){
        for(int m=0;m<N;m++){
            instream>>a;
            micro[i].push_back(a);
        }
    }
    for(int i=0;i<M;i++){
        for(int m=0;m<N;m++){
            counting=0;
            if(micro[i][m]=="#"){
                xq.push(m);
                yq.push(i);
                while(!xq.empty()){
                    x=xq.front();
                    y=yq.front();
                    if(x+1<N){
                        if(micro[y][x+1]=="#"&&x+1<N){
                            micro[y][x+1]="1";
                            xq.push(x+1);
                            yq.push(y);
                        }
                    }
                    if(x>0){
                        if(micro[y][x-1]=="#"&&x>0){
                            micro[y][x-1]="1";
                            xq.push(x-1);
                            yq.push(y);
                        }
                    }
                    if(y+1<M){
                        if(micro[y+1][x]=="#"&&y+1<M){
                            micro[y+1][x]="1";
                            xq.push(x);
                            yq.push(y+1);
                        }
                    }
                    if(y>0){
                        if(micro[y-1][x]=="#"&&y>0){
                            micro[y-1][x]="1";
                            xq.push(x);
                            yq.push(y-1);
                        }
                    }
                    micro[y][x]="0";
                    counting=counting+1;
                    xq.pop();
                    yq.pop();
                }
                if(counting>maximum){
                    maximum=counting;
                }
                if(counting>=K){
                    number++;
                }
            }
        }
    }
    outstream<<number<<" "<<maximum;
    outstream.close();
    instream.close();
}
