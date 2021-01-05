#include <bits/stdc++.h>
using namespace std;
int zero=0;
int one=0;


int main(){
    int t;
    cin>>t;
    vector<int> zero(41,0);
    vector<int> one(41,0);

    zero[0]=1;
    one[1] = 1;

    for(int i=2;i<41;i++){
        zero[i] = zero[i-2]+zero[i-1];
        one[i] = one[i-2]+one[i-1];
    }

    for(int i=0;i<t;i++){
        int a;
        cin>>a;

        cout<<zero[a]<<" "<<one[a]<<endl;
    }
}