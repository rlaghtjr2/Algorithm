#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,t;
    cin>>t;

    vector<long long> tri(101,0);
    tri[1]=1;
    tri[2]=1;
    tri[3]=1;

    for(int i=4;i<101;i++){
        tri[i] = tri[i-3]+tri[i-2];
    }

    for(int i=0;i<t;i++){
        cin>>n;
        cout<<tri[n]<<endl;
    }
}