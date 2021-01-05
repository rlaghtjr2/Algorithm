#include <bits/stdc++.h>
using namespace std;

int main(){
    string dial;
    int sec = 0;
    cin>>dial;

    for(int i=0;i<dial.size();i++){
        int a = (int)(dial.at(i))-65;
        if(a>=15 && a<=18){
            a = 15;
        }else if(a>=19 && a<=21){
            a = 19;
        }else if(a>=22){
            a=22;
        }
        sec = sec + (3+a/3);
    }
    cout<<sec;
}
