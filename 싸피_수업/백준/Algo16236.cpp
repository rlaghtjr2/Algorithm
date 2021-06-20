#include <bits/stdc++.h>

using namespace std;
int N;
int ans = 0;
int curBaby = 2;
int cnt = 0;
int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};
vector< pair<int,int> > fish;

void dfs( vector< vector<int> > &maps, pair<int, int> baby){
    int counting = 0;
    queue< pair<int, int> > que;
    vector< vector<bool> >v(N,vector<bool>(N));

    que.push(baby);
    v[baby.first][baby.second] = true;
    while(!que.empty()){
        counting++;
        int queSize = que.size();
        for(int i=0;i<queSize;i++){
            pair<int, int> p = que.front();
            que.pop();

            for(int j=0;j<4;j++){
                int nY = p.first+dy[j];
                int nX = p.second+dx[j];

                if(nY>=N || nY<0 || nX>=N || nX<0) continue;
                if(v[nY][nX]) continue;
                if(maps[nY][nX]>curBaby) continue;

                v[nY][nX] = true;
                if(maps[nY][nX]!=0 && maps[nY][nX] < curBaby){
                    fish.push_back(make_pair(nY,nX));
                }
                que.push(make_pair(nY,nX));
            }
        }

        if(fish.size()!=0) {
            ans+=counting;
            break;
        }
    }
}

bool compare(pair<int,int> a , pair<int,int> b){
    if(a.first==b.first){
        return a.second<b.second;
    }else{
        return a.first<b.first;
    }
}
int main(){
    cin>>N;
    vector< vector<int> >maps(N,vector<int>(N,0));
    pair<int,int> baby;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin>>maps[i][j];
            if(maps[i][j] == 9) baby = make_pair(i,j);
        }
    }

    while(true){
        dfs(maps,baby);        
        if(fish.size()!=0){
            sort(fish.begin(),fish.end(),compare);
            //ans += (abs(fish[0].first-baby.first) + abs(fish[0].second-baby.second));
            maps[fish[0].first][fish[0].second] = 9;
            maps[baby.first][baby.second] = 0;
            baby = make_pair(fish[0].first , fish[0].second);
            cnt++;
            if(cnt==curBaby){
                cnt = 0;
                curBaby++;
            }
            fish.clear();
        }else{
            break;
        } 
    }

    cout<<ans<<endl;
}