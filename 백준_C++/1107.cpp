#include <bits/stdc++.h>

using namespace std;
int n,m;
int minimum = 500001;
int result = 5000000;
vector<bool> isCheck(10);
vector<int> button;
queue<int> que;
void pushQue(){
    bool isRunning = true;
    while(!que.empty()){
        int front = que.front();
        que.pop();
        if(minimum<=abs(front-n)){
            isRunning = false;
            break;
        }else{
            minimum = abs(front-n);
            result = front;
        }
        if(front!=0){
            for(int j=0;j<button.size();j++){
                que.push(front*10+button[j]);
            }
        }
        
    }
}
int main(){
    cin>>n>>m;
    
    for(int i=0;i<m;i++){
        int broken;
        cin>>broken;
        isCheck[broken] = true;
    }

    for(int i=0;i<10;i++){
        if(!isCheck[i]){
            button.push_back(i);
            que.push(i);
        }
    }

    pushQue();
    int num = abs(result-n);
    int counting = 0;
    while(true){
        counting++;
        result = result/10;
        if(result==0){
            break;
        }
    }
    //counting = 몇자리수인지 ->번호누르기
    // num = 번호 이동 후 ++ 혹은 -- 버튼 누른 개수
    if(abs(n-100)<counting+num){
        cout<<abs(n-100)<<endl;
    }else{
        cout<<counting+num<<endl;
    }

}