#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b){
    int returnValue = 1;
    if(a>b){
        for(int i=2;i<=b;i++){
            if(a%i == 0 && b%i == 0){
                returnValue = i;
            }
        }
    }else if(a<b){
        for(int i=2;i<=a;i++){
            if(a%i == 0 && b%i == 0){
                returnValue = i;
            }
        }
    }else{
        return a;
    }
    return returnValue;
}
int main(){
    int n,m;
    cin>>n>>m;

    int ans = m-gcd(n,m);

    cout<<ans<<endl;
}