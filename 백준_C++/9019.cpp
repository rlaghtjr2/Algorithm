#include <bits/stdc++.h>
using namespace std;
string result; 
void bfs(int a, int b, vector<bool> &isCheck){
    queue< pair<string,int> > que;
    que.push(make_pair("",a));
    isCheck[a] = true;
    while(true){
        string word = que.front().first;
        int number = que.front().second;
        que.pop();
        int d = (number*2) % 10000;
        int s = number-1;
        int l;
        int r;
        vector<int> vecNum (4,0);
        if(s == -1){
            s = 9999;
        }
        
        vecNum[0] = number/1000;
        vecNum[1] = (number%1000)/100;
        vecNum[2] = (number%100)/10;
        vecNum[3] = number%10;
        
        l = vecNum[1]*1000 + vecNum[2] * 100 + vecNum[3] * 10 + vecNum[0];
        r = vecNum[0] * 100 + vecNum[1] * 10 + vecNum[2] + vecNum[3]*1000;

        if(d != b && !isCheck[d]){
            que.push(make_pair(word+"D",d));
            isCheck[d] = true;
        }else if(d == b){
            result = word+"D";
            break;
        }

        if(s != b && !isCheck[s]){
            que.push(make_pair(word+"S",s));
            isCheck[s] = true;
        }else if(s == b){
            result = word+"S";
            break;
        }

        if(l != b && !isCheck[l]){
            que.push(make_pair(word+"L",l));
            isCheck[l] = true;
        }else if(l == b){
            result = word+"L";
            break;
        }

        if(r != b && !isCheck[r]){
            que.push(make_pair(word+"R",r));
            isCheck[r] = true;
        }else if(r == b){
            result = word+"R";
            break;
        }
    }
}
int main(){
    int n,a,b;
    cin >> n;
    for(int i=0;i<n;i++){
        vector<bool> isCheck(10001,false);
        cin>>a>>b;
        bfs(a,b,isCheck);
        cout<<result<<endl;
    }
}