#include <bits/stdc++.h>
using namespace std;

int main(){

    while(true){
        int w,h;
        cin>>w>>h;
        int result = 0;
        if(w==0 && h==0){
            break;
        }else{
            vector< vector<int> >map(h,vector<int>(w,0));

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    int a;
                    cin>>a;
                    map[i][j] = a;
                }
            }

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(map[i][j] == 1){
                        result++;
                        queue< pair<int,int> > bfs;
                        bfs.push(make_pair(i,j));
            
                        while(!bfs.empty()){
                            pair<int,int> element = bfs.front();
                            bfs.pop();
                
                            if(element.first != h-1){
                                if(map[element.first+1][element.second] == 1){
                                    bfs.push(make_pair(element.first+1,element.second));
                                    map[element.first+1][element.second] = -1;
                                }

                                if(element.second != w-1){
                                    if(map[element.first+1][element.second+1] == 1){
                                        bfs.push(make_pair(element.first+1,element.second+1));
                                        map[element.first+1][element.second+1] = -1;
                                    }
                                }

                                if(element.second != 0){
                                    if(map[element.first+1][element.second-1] == 1){
                                        bfs.push(make_pair(element.first+1,element.second-1));
                                        map[element.first+1][element.second-1] = -1;
                                    }
                                }
                            }

                            if(element.first != 0){
                                if(map[element.first-1][element.second] == 1){
                                    bfs.push(make_pair(element.first-1,element.second));
                                    map[element.first-1][element.second] = -1;
                                }

                                if(element.second != w-1){
                                    if(map[element.first-1][element.second+1] == 1){
                                        bfs.push(make_pair(element.first-1,element.second+1));
                                        map[element.first-1][element.second+1] = -1;
                                    }
                                }

                                if(element.second != 0){
                                    if(map[element.first-1][element.second-1] == 1){
                                        bfs.push(make_pair(element.first-1,element.second-1));
                                        map[element.first-1][element.second-1] = -1;
                                    }
                                }
                            }

                            if(element.second != w-1){
                                if(map[element.first][element.second+1] == 1){
                                    bfs.push(make_pair(element.first,element.second+1));
                                    map[element.first][element.second+1] = -1;
                                }
                            }

                            if(element.second != 0){
                                if(map[element.first][element.second-1] == 1){
                                    bfs.push(make_pair(element.first,element.second-1));
                                    map[element.first][element.second-1] = -1;
                                }
                            }
                        }
                    }
                }
            }
            cout<<result<<endl;
        }
    }
}