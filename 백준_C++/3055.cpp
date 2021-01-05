#include <bits/stdc++.h>
using namespace std;

int r,c;

vector< vector<string> > bfsWater( vector< vector<string> >map){
    vector< vector<string> > compareMap = map;
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(map[i][j]=="*"){
                if(i != r-1){
                    if(map[i+1][j]!="X" && map[i+1][j] != "D"){
                        compareMap[i+1][j] = "*";
                    }
                }
                if(i != 0){
                    if(map[i-1][j] != "X" && map[i-1][j] != "D"){
                        compareMap[i-1][j] = "*";
                    }
                }
                if(j != c-1){
                    if(map[i][j+1]!="X" && map[i][j+1] != "D"){
                        compareMap[i][j+1] = "*";
                    }
                }
                if(j != 0){
                    if(map[i][j-1]!="X" && map[i][j-1] != "D"){
                        compareMap[i][j-1] = "*";
                    }
                }
            }
        }
    }

    return compareMap;
}

bool checking(vector< vector<string> >map){
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if(map[i][j] == "."){
                return false;
            }
        }
    }
    return true;
}
int main(){
    int result = 0;
    int counting = 0;
    cin>>r>>c;
    vector< vector<string> >map(r,vector<string>(c," "));
    vector< vector<bool> >check(r,vector<bool>(c,false));
    queue< pair<int,int> > bfs;
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            char a;
            cin>>a;
            map[i][j] = a;
            if(a == 'S'){
                bfs.push(make_pair(i,j));
                check[i][j] = true;
            }
        }
    }
    while(!bfs.empty()){
        counting++;
        map = bfsWater(map);
        int queSize = bfs.size();
        for(int i=0;i<queSize;i++){
            pair<int,int> location = bfs.front();
            bfs.pop();
            if(location.first != r-1){
                if(map[location.first+1][location.second] == "." && !check[location.first+1][location.second]){
                    bfs.push(make_pair(location.first+1,location.second));
                    check[location.first+1][location.second] = true;
                }else if(map[location.first+1][location.second] == "D"){
                    result = counting;
                }
            }
            if(location.first != 0){
                if(map[location.first-1][location.second] == "." && !check[location.first-1][location.second]){
                    bfs.push(make_pair(location.first-1,location.second));
                    check[location.first-1][location.second] = true;
                }else if(map[location.first-1][location.second] == "D"){
                    result = counting;
                }
            }
            if(location.second != c-1){
                if(map[location.first][location.second+1] == "." && !check[location.first][location.second+1]){
                    bfs.push(make_pair(location.first,location.second+1));
                    check[location.first][location.second+1] = true;
                }else if(map[location.first][location.second+1] == "D"){
                    result = counting;
                }
            }
            if(location.second != 0){
                if(map[location.first][location.second-1] == "." && !check[location.first][location.second-1]){
                    bfs.push(make_pair(location.first,location.second-1));
                    check[location.first][location.second-1] = true;
                }else if(map[location.first][location.second-1] == "D"){
                    result = counting;
                }
            }
        }
        if(result != 0){
            break;
        }
    }
    if(result == 0){
        cout<<"KAKTUS"<<endl;
    }else{
        cout<<result<<endl;
    }
}