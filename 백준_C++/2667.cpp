#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    int allHouse = 0;
    cin>>n;
    vector< vector<int> > house(n,vector<int>(n,0));
    vector<int> result;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%1d", &house[i][j]);
        }
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(house[i][j] == 1){
                int countingHouse = 0;
                stack< pair<int, int> > dfsHouse;
                dfsHouse.push(make_pair(i,j));

                while(!dfsHouse.empty()){
                    pair<int,int> popStack = dfsHouse.top();
                    int first = popStack.first;
                    int second = popStack.second;

                    if(house[first][second]!= -1){
                        house[first][second]= -1;
                        countingHouse++;
                    }
                    dfsHouse.pop();

                    if(first != n-1){
                        if(house[first+1][second] == 1){
                            dfsHouse.push(make_pair(first+1,second));
                        }
                    }

                    if(first != 0){
                        if(house[first-1][second] == 1){
                            dfsHouse.push(make_pair(first-1,second));
                        }
                    }

                    if(second != n-1){
                        if(house[first][second+1] == 1){
                            dfsHouse.push(make_pair(first,second+1));
                        }
                    }

                    if(second != 0){
                        if(house[first][second-1] == 1){
                            dfsHouse.push(make_pair(first,second-1));
                        }
                    }
    
                }
                result.push_back(countingHouse);
                allHouse++;
            }
        }
    }
    sort(result.begin(),result.end());
    cout<<allHouse<<endl;
    for(int i=0;i<result.size();i++){
        cout<<result[i]<<endl;
    }
}