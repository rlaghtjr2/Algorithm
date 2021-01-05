#include <bits/stdc++.h>
using namespace std;
int k,N;
int main(){
    ifstream instream("hamburg.inp");
    ofstream outstream("hamburg.out");
    vector<string> li;
    string a;
    int c=0;
    int h=0;
    instream>>k>>N;
    for(int i=0;i<N;i++){
        instream>>a;
        li.push_back(a);
    }
    for(int i=0;i<N; i++){
        if(li[i]=="P"){
            for(int a=k;a>=1;a--){
                if(i-a<0){
                    continue;}
                if(li[i-a]=="H"){
                    li[i-a]="F";
                    c++;
                    h=1;
                    break;}}
            if(h==0){
                for(int a=1;a<=k;a++){
                    if(i+a>=N)
                        continue;
                    else if(li[i+a]=="H"){
                        li[i+a]="F";
                        c++;
                        break;}}}}
        h=0;
    }
    outstream<<c<<endl;
    instream.close();
    outstream.close();
}
