#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,m;
    int ans = 0;
    cin>>n>>m;

    int min;
    vector< vector<int> >squ(n,vector<int>(m));

    for(int i=0;i<n;i++){
        // int a;
        // cin>>a;

        for(int j=0;j<m;j++){
        //     squ[i][m-j-1] = a%10;
        //     a=a/10;
            scanf("%1d",&squ[i][j]);
        }
    }

    if(n>m){
        min = m;
    }else{
        min = n;
    }
    min--;

    while(ans==0){
        for(int i=0;i<n-min;i++){
            for(int j=0;j<m-min;j++){
                int first = squ[i][j];
                int second = squ[i+min][j];
                int third = squ[i][j+min];
                int forth = squ[i+min][j+min];

                if(first == second && second == third && third == forth){
                    ans = min+1;
                    break;
                }
            }
            if(ans!=0){
                break;
            }
        }
        min--;
    }
    cout<<ans*ans<<endl;
}