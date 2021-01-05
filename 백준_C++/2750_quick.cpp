#include <bits/stdc++.h>

using namespace std;
vector<int> quick(vector<int> num){
    if(num.size()==0 || num.size()==1){
        return num;
    }
    vector<int> down;
    vector<int> equal;
    vector<int> up;
    vector<int> final;

    int middle = num[rand()%num.size()];

    for(int i=0;i<num.size();i++){
        if(num[i]<middle){
            down.push_back(num[i]);
        }else if(num[i] == middle){
            equal.push_back(num[i]);
        }else{
            up.push_back(num[i]);
        }
    }

    down = quick(down);
    up = quick(up);

    for(int i=0;i<down.size();i++){
        final.push_back(down[i]);
    }
    for(int i=0;i<equal.size();i++){
        final.push_back(equal[i]);
    }
    for(int i=0;i<up.size();i++){
        final.push_back(up[i]);
    }
    
    return final;
    
}
int main(){
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    int n;
    cin>>n;

    vector<int> num(n);

    for(int i=0;i<n;i++){
        cin>>num[i];
    }
    num = quick(num);
    for(int i=0;i<n;i++){
        cout<<num[i]<<endl;
    }
}