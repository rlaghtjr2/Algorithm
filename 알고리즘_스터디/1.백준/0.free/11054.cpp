#include <bits/stdc++.h>

using namespace std;
int n;
int s[1000];
int ans = 0;
int main(){
    cin>>n;
    vector<int> num(n,0);
    vector<int> al(n,1);
    vector<int> nae(n,1);
    vector<int> sum(n,0);
    for(int i=0;i<n;i++){
        cin>>num[i];
    }
    al[0] = 1;
    nae[n-1] = 1;

    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(num[i]>num[j]){
                al[i] = max(al[j]+1,al[i]);
            }
        }

        for(int j=n-1;j>=n-1-i;j--){
            if(num[n-i-1]>num[j]){
                nae[n-i-1] = max(nae[j]+1,nae[n-i-1]);
            }
        }
    }

    for(int i=0;i<n;i++){
        ans = max(al[i]+nae[i],ans);
    }
    cout<<ans-1<<endl;
}