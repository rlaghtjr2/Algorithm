#include <bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int> num(n);

    for(int i=0;i<n;i++){
        cin>>num[i];
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<n-i-1;j++){
            if(num[j]>num[j+1]){
                int tmp = num[j];
                num[j] = num[j+1];
                num[j+1] = tmp;
            }
        }
    }

    for(int i=0;i<n;i++){
        cout<<num[i]<<endl;
    }
}