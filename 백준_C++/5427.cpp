#include <bits/stdc++.h>
using namespace std;
int n,h,w;
int bfs(vector< vector<char> > &building,pair<int,int> people, queue< pair<int,int> > &fire, vector< vector<bool> >&isCheck){
    int result = 0;
    queue< pair<int,int> >que;
    que.push(people);

    while(true){
        result++;
        int queSize = que.size();
        int fireSize = fire.size();

        for(int i=0;i<queSize;i++){
            int first = que.front().first;
            int second = que.front().second;
            que.pop();


            if(building[first][second] != '*'){
                if(first != h-1){
                    if(building[first+1][second] == '.' && !isCheck[first+1][second]){
                        que.push(make_pair(first+1,second));
                        isCheck[first+1][second] = true;
                    }
                }else{
                    return result;
                }

                if(first != 0){
                    if(building[first-1][second] == '.' && !isCheck[first-1][second]){
                        que.push(make_pair(first-1,second));
                        isCheck[first-1][second] = true;
                    }
                }else{
                    return result;
                }

                if(second != w-1){
                    if(building[first][second+1] == '.' && !isCheck[first][second+1]){
                        que.push(make_pair(first,second+1));
                        isCheck[first][second+1] = true;
                    }
                }else{
                    return result;
                }

                if(second != 0){
                    if(building[first][second-1] == '.' && !isCheck[first][second-1]){
                        que.push(make_pair(first,second-1));
                        isCheck[first][second-1] = true;
                    }
                }else{
                    return result;
                }
            }//for
        }
        if(que.size() == 0){
            return -1;
        }
        
        for(int i=0;i<fireSize;i++){
            int first = fire.front().first;
            int second = fire.front().second;
            
            fire.pop();

            if(first != h-1){
                if(building[first+1][second] == '.'){
                    building[first+1][second] = '*';
                    fire.push(make_pair(first+1,second));
                }
            }

            if(first != 0){
                if(building[first-1][second] == '.'){
                    building[first-1][second] = '*';
                    fire.push(make_pair(first-1,second));
                }
            }

            if(second != w-1){
                if(building[first][second+1] == '.'){
                    building[first][second+1] = '*';
                    fire.push(make_pair(first,second+1));
                }
            }

            if(second != 0){
                if(building[first][second-1] == '.'){
                    building[first][second-1] = '*';
                    fire.push(make_pair(first,second-1));
                }
            }
        }
    } // while
}
int main(){
    cin>>n;
    for(int cycle=0;cycle<n;cycle++){
        pair<int,int> people;
        queue< pair<int,int> >fire;
        int result;
        cin>>w>>h;
        vector< vector<char> >building(h,vector<char>(w,' '));
        vector< vector<bool> >isCheck(h,vector<bool>(w,false));

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                char a;
                cin>>a;
                building[i][j] = a;
                if(a == '@'){
                    people = make_pair(i,j);
                }else if(a == '*'){
                    fire.push(make_pair(i,j));
                }
            }
        }


        result = bfs(building,people,fire,isCheck);
        if(result == -1){
            cout<<"IMPOSSIBLE"<<endl;
        }else{
            cout<<result<<endl;
        }
    }
}