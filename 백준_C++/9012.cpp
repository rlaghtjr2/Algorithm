#include <bits/stdc++.h>
using namespace std;
int main(){
    string ps;
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>ps;
        stack<int> first;
        for(int j=0;j<ps.size();j++){
            if(ps.at(j)=='('){
                first.push(1);
            }else if(ps.at(j)==')'){
                if(first.size()==0){
                    cout<<"NO"<<endl;
                    break;
                }else if(first.size()!=0){
                    first.pop();
                }
            }
            if(j==ps.size()-1){
                if(first.size()==0){
                    cout<<"YES"<<endl;
                }else{
                    cout<<"NO"<<endl;
                }
            }
        }
    }
}
