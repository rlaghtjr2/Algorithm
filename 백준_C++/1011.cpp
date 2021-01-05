#include <bits/stdc++.h>
using namespace std;

int main(){
    int t;
    cin>>t;
    for(int p=0;p<t;p++){
        long long x,y;
        cin>>x>>y;

        long long ans = 0;
        int count = 1;
        int divedTwo = 0;
        long long sum = 0;
        while(sum<=(y-x)){
            if(divedTwo%2 == 0){
                sum=sum+count;
            }else{
                sum=sum+count;
                count++;
            }
            divedTwo=(divedTwo+1)%2;
            if(sum!=(y-x)){
                ans++;
            }
        }
        cout<<ans<<endl;
    }
}