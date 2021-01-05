#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    int answer = 0;
    cin>>n;

    vector<int> a(n);
    vector<int> b(n);

    for(int i=0;i<n;i++){
        cin>>a[i];
    }

    for(int i=0;i<n;i++){
        cin>>b[i];
    }

    sort(a.begin(),a.end());
    sort(b.rbegin(),b.rend());

    for(int i=0;i<n;i++){
        answer = answer+(a[i]*b[i]);
    }

    cout<<answer<<endl;
}