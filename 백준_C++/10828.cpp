#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    stack<int> test_stack;
    for(int i=0;i<n;i++){
        string a;
        cin>>a;

        if(a=="push"){
            int b;
            cin>>b;
            test_stack.push(b);
        }else if(a=="pop"){
            if(test_stack.size()==0){
                cout<<"-1"<<endl;
            }else{
                cout<<test_stack.top()<<endl;
                test_stack.pop();
            }
        }else if(a=="size"){
            cout<<test_stack.size()<<endl;
        }else if(a == "empty"){
            if(test_stack.empty()){
                cout<<"1"<<endl;
            }else{
                cout<<"0"<<endl;
            }
        }else if(a == "top"){
            if(test_stack.size()==0){
                cout<<"-1"<<endl;
            }else{
                cout<<test_stack.top()<<endl;
            }
        }
    }
}