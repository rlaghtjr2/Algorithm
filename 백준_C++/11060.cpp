#include <bits/stdc++.h>
using namespace std;

int main(){
    int N;
    int current = 0;
    cin>>N;
    vector<int> Ai;
    for(int i=0;i<N;i++){
        int a;
        cin>>a;
        Ai.push_back(a);
    }
    int counting;
    if(N==1){
        cout<<"0"<<endl;
    }else{
        vector<int> ans(N,10000);
        for(int i=0;i<=Ai[0];i++){
            ans[i]=1;
        }
        for(int i=Ai[0]+1;i<N;i++){
            for(int m=0;m<i;m++){
                if(m+Ai[m]>=i){
                    if(ans[i]>ans[m]+1){
                        ans[i]=ans[m]+1;
                    }
                }
            }
        }
        if(ans[N-1]==10000){
            cout<<"-1";
        }else{
            cout<<ans[N-1];
        }
    }
}
