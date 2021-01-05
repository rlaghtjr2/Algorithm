#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,kim,lim;
    cin>>n>>kim>>lim;
    int ans = 0;
    while(true){
        ans++;
        if(kim>lim){
            if(kim%2==0 && kim-lim == 1){
                break;
            }
        }else{
            if(lim%2==0 && lim-kim == 1){
                break;
            }
        }

        kim=(kim+1)/2;
        lim = (lim+1)/2;
    }

    cout<<ans<<endl;
}