#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;

    vector<long long> tail(n+1,0);

    tail[1] = 1;
    tail[2] = 2;

    for(int i=3;i<n+1;i++){
        tail[i] = (tail[i-2]+tail[i-1])%15746;
    } 
    cout<<tail[n]<<endl;
}