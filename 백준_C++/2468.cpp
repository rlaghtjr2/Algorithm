#include <bits/stdc++.h>
using namespace std;
int n;
int dfs(vector< vector<int> >area, int k){
    int result = 0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(area[i][j]>k){
               stack< pair<int,int> > dfs;
                dfs.push(make_pair(i,j));

                while(!dfs.empty()){
                    int first = dfs.top().first;
                    int second = dfs.top().second;
                    area[first][second] = -1;
                    dfs.pop();

                    if(first != n-1){
                        if(area[first+1][second]>k){
                            dfs.push(make_pair(first+1,second));
                        }
                    }
                    if(first != 0){
                        if(area[first-1][second]>k){
                            dfs.push(make_pair(first-1,second));
                        }
                    }
                    if(second != n-1){
                        if(area[first][second+1]>k){
                            dfs.push(make_pair(first,second+1));
                        }
                    }
                    if(second != 0){
                        if(area[first][second-1]>k){
                            dfs.push(make_pair(first,second-1));
                        }
                    }
                }
                result++;
            }
        }
    }
    return result;
}
int main(){
    int maximum = 1;
    cin>>n;
    vector< vector<int> >area(n,vector<int>(n,0));
    vector<bool> check(101,false);
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            int a;
            cin>>a;
            area[i][j]=a;
            check[a]=true;
        }
    }

    for(int k=1; k<101; k++){
        if(check[k]){
            int counting = dfs(area,k);
            if(counting>maximum){
                maximum = counting;
            }
        }
    }
    cout<<maximum;
}