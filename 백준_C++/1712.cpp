#include <bits/stdc++.h>
using namespace std;
int main(){
    long long a,b,c;
    long long payment;
    long long revenue;
    long long ans = 1;
    cin>>a>>b>>c;
    payment = a+b;
    revenue = c;
    if(b>=c){
        ans=-1;
    }else{
       ans = (a/(c-b))+1;
    }
    cout<<ans;
}
