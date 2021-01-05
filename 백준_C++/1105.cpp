#include <bits/stdc++.h>
using namespace std;

int main(){
    int l,r;
    cin>>l>>r;
    int a=1000000000;
    bool isL = false;
    bool isR = false;
    int ans = 0;
    int dif = r-l;
    while(a){
        if(dif>=a){
            break;
        }
        if(!isL && l/a != 0){
            isL = true;
        }
        if(!isR && r/a != 0){
            isR = true;
        }

        if(isL && isR){
            if(l/a == 8 && r/a == 8){
                ans++;
            }   
            l=l%a;
            r=r%a;
        }
        a=a/10;
        
    }
    cout<<ans<<endl;
}