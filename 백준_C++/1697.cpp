#include <bits/stdc++.h>
using namespace std;

int main(){
    vector<bool> check(100000,false);
    queue<int> que;
    int n,k;
    int result = 0;
    bool isRunning = true;
    cin>>n>>k;

    que.push(n);

    if(n==k){
        isRunning = false;
    }
    check[n]= true;
    while(isRunning){
        int queSize = que.size();
        for(int i=0;i<queSize;i++){
            int quePop = que.front();
            
            que.pop();
            if(quePop == k){
                isRunning = false;
                break;
            }
            if(quePop*2<=100000){
                if(!check[quePop*2]){
                    que.push(quePop*2);
                    check[quePop*2] = true;
                }
            }
            if(quePop+1 <= 100000){
                if(!check[quePop+1]){
                    que.push(quePop+1);
                    check[quePop+1] = true;
                } 
            }
            if(quePop-1 >= 0){
                if(!check[quePop-1]){
                    que.push(quePop-1);
                    check[quePop-1] = true;
                }
            }
        }
        if(isRunning){
            result++;
        }
    }
    cout<<result<<endl;
}