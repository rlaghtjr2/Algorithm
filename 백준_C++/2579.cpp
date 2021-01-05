#include <bits/stdc++.h>
using namespace std;

int max(int a, int b){
    if(a>b){
        return a;
    }else{
        return b;
    }
}
int main(){
    int n;
    cin>>n;
    vector<int> stairs(n,0);
    vector< vector<int> > dynamic(n,vector<int>(2,0));
    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        stairs[i] = a;
    }

    if(n==1){
        cout<<stairs[0]<<endl;
    }else{
        dynamic[0][0] = stairs[0];
        dynamic[0][1] = 0;
        dynamic[1][0] = dynamic[0][0]+stairs[1];
        dynamic[1][1] = stairs[1];
        
        for(int i=2;i<n;i++){
            dynamic[i][0] = dynamic[i-1][1]+stairs[i];
            dynamic[i][1] = max(dynamic[i-2][0],dynamic[i-2][1])+ stairs[i];
        }

        cout<<max(dynamic[n-1][0],dynamic[n-1][1])<<endl;
    }
}