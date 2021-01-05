#include <bits/stdc++.h>
using namespace std;
int N;
int main(){
    int waitTime =0;
    int ans=0;
    cin>>N;
    vector<int> waiting(N,0);

    for(int i=0;i<N;i++){
        int a;
        cin>>a;
        waiting[i] = a;
    }
    sort(waiting.begin(),waiting.end());
    for(int i=0;i<N;i++){
        waitTime=waitTime+waiting[i];
        ans=ans+waitTime;
    }
    cout<<ans;
}
