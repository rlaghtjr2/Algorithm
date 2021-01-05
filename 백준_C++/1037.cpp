#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    int result;
    cin>>n;

    vector<int>vec;

    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        vec.push_back(a);
    }
    sort(vec.begin(),vec.end());
    result = vec[0] * vec[vec.size()-1];
    cout<<result<<endl;
}