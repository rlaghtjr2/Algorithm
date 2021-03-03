#include <bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int> chu(n,0);
    int counting = 0;
    for(int i=0;i<n;i++){
        cin>>chu[i];
    }

    sort(chu.begin(),chu.end());

    
    for(int i=0;i<n;i++){
        if(chu[i]>counting+1){
            break;
        }else{
            counting+=chu[i];
        }
    }

    cout<<counting+1<<endl;
}