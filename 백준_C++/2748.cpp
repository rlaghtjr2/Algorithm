#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;

    vector<long long> fibonacci(91,0);
    fibonacci[0] = 0;
    fibonacci[1] = 1;
    for(int i=2;i<91;i++){
        fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
    }

    cout<<fibonacci[n]<<endl;

}