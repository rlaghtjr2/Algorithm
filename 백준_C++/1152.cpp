#include <bits/stdc++.h>
using namespace std;
int main(){
    int ans = 0;
    char word[1000000];
    cin.getline(word,1000000);

    for(int i=0;i<1000000;i++){
        if(word[i]=='\0'){
            break;
        }
        if(word[i]!=' ' && i==0){
            ans++;
        }else if(word[i]!=' ' && word[i-1]==' '){
            ans++;
        }
    }
    cout<<ans;
}
