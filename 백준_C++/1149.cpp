#include <bits/stdc++.h>
using namespace std;
int min(int a, int b){
    if(a>b){
        return b;
    }else{
        return a;
    }
}
int main(){
    int n;
    int result;
    cin>>n;
    vector< vector<int> > house(n,vector<int>(3,0));
    vector< vector<int> > dynamic(3,vector<int>(n,0));
    for(int i=0;i<n;i++){
        int a,b,c;
        cin>>a>>b>>c;

        house[i][0] = a;
        house[i][1] = b;
        house[i][2] = c;
    }

    dynamic[0][0] = house[0][0];
    dynamic[1][0] = house[0][1];
    dynamic[2][0] = house[0][2];

    for(int i=1;i<n;i++){
        dynamic[0][i] = min(dynamic[1][i-1]+house[i][0], dynamic[2][i-1]+house[i][0]);
        dynamic[1][i] = min(dynamic[0][i-1]+house[i][1], dynamic[2][i-1]+house[i][1]);
        dynamic[2][i] = min(dynamic[0][i-1]+house[i][2], dynamic[1][i-1]+house[i][2]);
    }

    result = dynamic[0][n-1];
    if(result>dynamic[1][n-1]){
        result = dynamic[1][n-1];
    }
    if(result>dynamic[2][n-1]){
        result = dynamic[2][n-1];
    }
    cout<<result<<endl;
}