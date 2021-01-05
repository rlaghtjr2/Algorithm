#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;

    vector<int> vec;
    queue<int> que;
    vector< vector<int> >vec2(1001,vector<int>(0));

    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        vec.push_back(a);
        que.push(a);
    }

    sort(vec.begin(),vec.end());

    for(int i=0;i<n;i++){
        vec2[vec[i]].push_back(i);
    }

    while(!que.empty()){
        int a = que.front();
        que.pop();
        cout<<vec2[a][0]<<" ";
        vec2[a].erase(vec2[a].begin());
    }


}