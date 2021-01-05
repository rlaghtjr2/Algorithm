#include <bits/stdc++.h>

using namespace std;
int radix(int n){
    vector< queue<int> >rad(10);
    int count = 0;
    int result = 0;
    while(n!=0){
        rad[n%10].push(n%10);
        count++;

        n=n/10;
    }

    for(int i=9;i>=0;i--){
        for(int j=0;j<rad[i].size();j++){
            result = result + pow(10,count-1)*i;
            count--;
        }
    }
    cout<<result<<endl;
    return result;
}
int main(){
    int n;
    cin>>n;

    radix(n);
}