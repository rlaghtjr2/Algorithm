#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    int result = 0 ;
    cin>>n;

    bool isRunning = true;
    int count = 0;
    
    queue<int> bfs;

    vector<bool> check(1000000,false);

    bfs.push(n);
    if( n == 1){
        cout<<result<<endl;
        isRunning = false;
    }
    while(isRunning){
        result++;
        int queSize = bfs.size();
        for(int i=0;i<queSize;i++){
            int element = bfs.front();
            bfs.pop();

            if(element%3 == 0){
                bfs.push(element/3);
                if(element/3 == 1){
                    cout<<result<<endl;
                    isRunning = false;
                    break;
                }
            }
            if(element%2 == 0){
                bfs.push(element/2);
                if(element/2 == 1){
                    cout<<result<<endl;
                    isRunning = false;
                    break;
                }
            }
            bfs.push(element-1);
            if(element-1 == 1){
                cout<<result<<endl;
                isRunning = false;
                break;
            }
        }
    }
}