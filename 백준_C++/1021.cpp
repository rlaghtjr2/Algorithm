#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,m;
    cin>>n>>m;
    int answer = 0;
    deque<int> deq;
    queue<int> que;
    for(int i=0;i<m;i++){
        int a;
        cin>>a;
        que.push(a);
    }

    for(int i=0;i<n;i++){
        deq.push_back(i+1);
    }

    while(!que.empty()){
        int a = que.front();
        int location;
        que.pop();

        deque<int> frontDeq(deq);
        deque<int> backDeq(deq);

        while(true){
            int front1 = frontDeq.front();
            int front2 = backDeq.front();

            if(front1 == a){
                frontDeq.pop_front();
                deq = frontDeq;
                break;
            }else if(front2 == a){
                backDeq.pop_front();
                deq = backDeq;
                break;
            }

            frontDeq.push_back(frontDeq.front());
            frontDeq.pop_front();
            
            backDeq.push_front(backDeq.back());
            backDeq.pop_back();

            answer++;
        }
        
    }

    cout<<answer<<endl;
}