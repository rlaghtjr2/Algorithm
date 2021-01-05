#include <bits/stdc++.h>
using namespace std;

int main(){
    int T,H,W,N;
    cin>>T;
    for(int i=0;i<T;i++){
        string a,b;
        cin>>H>>W>>N;
        if(N%H!=0){
            a = to_string(N%H); //Ãþ¼ö
            b = to_string((N/H)+1); //¹æ¹øÈ£

            if(b.size()==1){
                b = '0'+b;
            }
        }else{
            a = to_string(H);
            b = to_string((N/H));
            if(b.size()==1){
                b = '0'+b;
            }
        }
        cout<<a+b<<endl;
    }
}
