#include <bits/stdc++.h>
using namespace std;

int main(){
    int l,n;
    int pre,next;
    int ans = 0;
    cin>>l;
    vector<int> vec;
    for(int i=0;i<l;i++){
        int a;
        cin>>a;
        vec.push_back(a);
    }
    sort(vec.begin(),vec.end());
    cin>>n;

    for(int i=0;i<vec.size();i++){
        if(n<vec[i] && i!=0){
            pre = vec[i-1];
            next = vec[i];
            break;
        }else if(n<vec[i] && i==0){
            pre = 0;
            next = vec[i];
            break;
        }else if(n==vec[i]){
            pre = 0;
            next = 0;
            break;
        }
    }
    int a = n;
    if((pre==0 && next ==0)||(next-pre == 2)){
        cout<<0<<endl;
    }else{
        if(pre+1 != n){
            ans = (n-pre-1)*(next-n);
        }
        if(n+1 != next){
            ans = ans+(next-n-1);
        }
        cout<<ans<<endl;
    }
    

}