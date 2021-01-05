#include <bits/stdc++.h>
using namespace std;

int main(){
    int sugar,ans,five,three;
    cin>>sugar;
    five = sugar/5;

    for(int i = five; i>=0; i--){
        three = (sugar - five*5) % 3;
        if(three == 0){
            ans = five + (sugar-five*5)/3;
            break;
        }
        if(i==0){
            ans=-1;
        }
        five--;
    }

    cout<<ans;
}
