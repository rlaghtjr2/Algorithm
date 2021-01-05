#include <bits/stdc++.h>
using namespace std;

int main(){
    int answer = 99;
    int n;
    cin>>n;
    if(n<100){
        cout<<n;
    }else if(n<111){
        cout<<answer;
    }else{
        for(int i=111;i<=n;i++){
            int a,b,c;
            a = i/100;
            b = (i%100)/10;
            c = (i%10);

            if((a-b) == (b-c)){
                answer++;
            }
        }

        cout<<answer<<endl;
    }
}