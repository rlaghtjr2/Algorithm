#include <bits/stdc++.h>
using namespace std;

int main(){
    int t,m,n,k;
    
    cin>>t;
    for(int testCase=0;testCase<t;testCase++){
        int result = 0;
        cin>>m>>n>>k;
        vector< vector<int> > cab(n,vector<int>(m,0));
        for(int i=0;i<k;i++){
            int col,row;
            cin>>row>>col;
            cab[col][row]=1;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(cab[i][j]==1){
                    stack<pair<int,int> > cabStack;
                    cabStack.push(make_pair(i,j));
                    while(!cabStack.empty()){
                        pair<int,int> dfsPair = cabStack.top();
                        cabStack.pop();
                        
                        cab[dfsPair.first][dfsPair.second] = -1;
                        if(dfsPair.first  != n-1){
                            if(cab[dfsPair.first+1][dfsPair.second]==1){
                                cabStack.push(make_pair(dfsPair.first+1,dfsPair.second));
                            }
                        }
                        if(dfsPair.first != 0){
                            if(cab[dfsPair.first-1][dfsPair.second]==1){
                                cabStack.push(make_pair(dfsPair.first-1,dfsPair.second));
                            }
                        }
                        if(dfsPair.second != m-1){
                            if(cab[dfsPair.first][dfsPair.second+1]==1){
                                cabStack.push(make_pair(dfsPair.first,dfsPair.second+1));
                            }
                        }
                        if(dfsPair.second != 0){
                            if(cab[dfsPair.first][dfsPair.second-1]==1){
                                cabStack.push(make_pair(dfsPair.first,dfsPair.second-1));
                            }
                        }
                    }
                    result++;
                }
            }
        }
        cout<<result<<endl;
    }
}