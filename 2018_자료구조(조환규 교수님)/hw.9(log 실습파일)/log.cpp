#include <bits/stdc++.h>
using namespace std;
int N,K,i,n1,n2,n3,n,Q;
int main(){
ifstream instream ("log.inp");
ofstream outstream ("log.out");
instream>>N>>K;
struct ds{
int il;
int ts;
int te;
};
list<ds>log;
list<ds>::iterator it;
vector<int> time;
vector<int>::iterator it2;
for(i=0;i<N;i++){
    instream>>n1>>n2>>n3;
    struct ds a={n1,n2,n3};
    log.push_back(a);
}
for(i=0;i<K;i++){
    instream>>Q;
    for(it=log.begin();it!=log.end();it++){
        if(Q>=(it)->ts&&Q<=(it)->te){
            time.push_back((it)->il);
        }
    }
    sort(time.begin(),time.end());
    if(!time.empty()){
        for(it2=time.begin();it2!=time.end();it2++){
            outstream<<*it2<<" ";
        }
    }
    else
        outstream<<"0";
    outstream<<endl;
    time.clear();
}
instream.close();
outstream.close();
}
