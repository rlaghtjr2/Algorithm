#include <bits/stdc++.h>

using namespace std;
int n,m,k;
int max = 0;
int main(){
    int result = 0;
    int counting = 1;
    int start = 0;
    cin>>n>>m;
    vector< vector<int> >lamp(n,vector<int>(m+1,0));
    
    for(int i=0;i<n;i++){
        for(int j=1;j<=m;j++){
            char isTurn;
            cin>>isTurn;
            lamp[i][j] = (int)isTurn-48;
        }
    }
    cin>>k;
    sort(lamp.rbegin(),lamp.rend());
    
    for(int i=0;i<lamp.size();i++){
        if(i!=n-1){
            if(lamp[i]==lamp[i+1]){
                counting++;
            }else{
                for(int j=start;j<=i;j++){
                    lamp[j][0] = counting;
                }
                counting = 1;
                start = i+1;
            }
        }else{
            for(int j=start;j<=n-1;j++){
                lamp[j][0] = counting;
            }
        }
    }
    lamp.erase(unique(lamp.begin(),lamp.end()),lamp.end());
    sort(lamp.rbegin(),lamp.rend());
    for(int i=0;i<lamp.size();i++){
        int zeroCount = 0;
        for(int j=1;j<=m;j++){
            if(lamp[i][j] == 0){
                zeroCount++;
            }
        }

        if(zeroCount==k){
            result = lamp[i][0];
            break;
        }else if(zeroCount<k){
            if((k-zeroCount)%2 == 0){
                result = lamp[i][0];
                break;
            }
        }
    }
    
    cout<<result<<endl;
}