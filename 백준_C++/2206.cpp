#include <bits/stdc++.h>
using namespace std;
struct Element
{
    int n;
    int m;
    bool isBreak;
};

int main(){
    int n,m;
    int result = 0;
    bool isRunning = true;
    cin>>n>>m;

    vector< vector<int> >map(n,vector<int>(m,0));
    vector< vector<bool> >nobreakCheck(n,vector<bool>(m,0));
    vector< vector<bool> >breakCheck(n,vector<bool>(m,0));
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            scanf("%1d", &map[i][j]);
        }
    }

    queue<Element> bfs;
    Element b = {0,0,false};

    bfs.push(b);

    while(!bfs.empty() && isRunning){
        int queSize = bfs.size();
        result++;
        for(int i=0;i<queSize; i++){
            Element element = bfs.front();
            bfs.pop();
            if(element.n == n-1 && element.m == m-1){
                isRunning = false;
                break;
            }
            if(!element.isBreak && !nobreakCheck[element.n][element.m]){
                // 안부신거
                nobreakCheck[element.n][element.m] = true;
                if(element.n != n-1){
                    if(map[element.n+1][element.m] == 0 && !nobreakCheck[element.n+1][element.m]){
                        Element a = {element.n+1,element.m,element.isBreak};
                        bfs.push(a);
                    }else if(map[element.n+1][element.m] == 1 && !nobreakCheck[element.n+1][element.m]){
                        Element a = {element.n+1,element.m,true};
                        bfs.push(a);
                    }   
                }

                if(element.n != 0){
                    if(map[element.n-1][element.m] == 0 && !nobreakCheck[element.n-1][element.m]){
                        Element a = {element.n-1,element.m,element.isBreak};
                        bfs.push(a);
                    }else if(map[element.n-1][element.m] == 1 && !nobreakCheck[element.n-1][element.m]){
                        Element a = {element.n-1,element.m,true};
                        bfs.push(a);
                    }
                }

                if(element.m != m-1){
                    if(map[element.n][element.m+1] == 0 && !nobreakCheck[element.n][element.m+1]){
                        Element a = {element.n,element.m+1,element.isBreak};
                        bfs.push(a);
                    }else if(map[element.n][element.m+1] == 1 && !nobreakCheck[element.n][element.m+1]){
                        Element a = {element.n,element.m+1,true};
                        bfs.push(a);
                    }
                }

                if(element.m != 0){
                    if(map[element.n][element.m-1] == 0 && !nobreakCheck[element.n][element.m-1]){
                        Element a = {element.n,element.m-1,element.isBreak};
                        bfs.push(a);
                    }else if(map[element.n][element.m-1] == 1 && !nobreakCheck[element.n][element.m-1]){
                        Element a = {element.n, element.m-1,true};
                        bfs.push(a);
                    }
                }
            }else if(element.isBreak && !breakCheck[element.n][element.m]){
                //부신거
                breakCheck[element.n][element.m] = true;
                if(element.n != n-1){
                    if(map[element.n+1][element.m] == 0 && !breakCheck[element.n+1][element.m]){
                        Element a = {element.n+1,element.m,element.isBreak};
                        bfs.push(a);
                    }
                }

                if(element.n != 0){
                    if(map[element.n-1][element.m] == 0 && !breakCheck[element.n-1][element.m]){
                        Element a = {element.n-1,element.m,element.isBreak};
                        bfs.push(a);
                    }
                }

                if(element.m != m-1){
                    if(map[element.n][element.m+1] == 0 && !breakCheck[element.n][element.m+1]){
                        Element a = {element.n,element.m+1,element.isBreak};
                        bfs.push(a);
                    }
                }

                if(element.m != 0){
                    if(map[element.n][element.m-1] == 0 && !breakCheck[element.n][element.m-1]){
                        Element a = {element.n,element.m-1,element.isBreak};
                        bfs.push(a);
                    }
                }
            }
        }
    }
    if(!isRunning){
        cout<<result<<endl;
    }else{
        cout<<-1<<endl;
    }
}