#include <bits/stdc++.h>
using namespace std;
long long com(int n, int m){
    long long result = 1;
    long long a=n;
    vector<bool> isCheck(a+1,true);
    isCheck[0] = false;
    isCheck[1] = false;
    for(int i=m;i>m-n;i--){
        result = result * i;
        //cout<<i<<"곱"<<endl;
        for(int j=2;j<a+1;j++){
            if(isCheck[j] && result % j == 0){
                result = result/j;
                isCheck[j] = false;
               // cout<<j<<"나눔"<<endl;
            }
        }
    }
    while(true){
        bool isStop = false;
        for(int i=2;i<a+1;i++){
            if(isCheck[i]){
                isStop = true;
                if(result % i == 0){
                    result = result/i;
                    isCheck[i] = false;
                    //cout<<i<<"나눔"<<endl;
                }
            }
            //cout<<result<<" "<<i<<endl;
        }
        if(!isStop){
            break;
        }
    }
    return result;
}
int main(){
    int t;
    cin>>t;
    for(int i=0;i<t;i++){
        int n,m;
        long long answer;
        cin>>n>>m;

        answer = com(n,m);
        cout<<answer<<endl;

    }
    
}