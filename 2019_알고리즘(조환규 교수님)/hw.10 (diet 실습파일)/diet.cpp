#include <bits/stdc++.h>
using namespace std;
int N;
/*bool backtracking(vector<int>&ans, int q){
    vector<int> same;
    same = ans;
    int start=-1;
    if(ans[q]==0){
        ans[q]=1;
        if(q!=N-1){
            for(int i=q+1;i<N;i++){
                ans[i]=0;
            }
        }
    }
    else if(ans[q]==1){
        for(int i=q;i>=0;i--){
            if(ans[i]==0){
                ans[i]=1;
                start=i+1;
                break;
            }
        }
        if(start!=-1){
            for(int i=start;i<N;i++){
                ans[i]=0;
            }
        }
    }
    if(ans==same){
        return false;
    }
    return true;
}
bool checkfood(vector<int> sumfood, vector<int> minnu){
    for(int i=0;i<4;i++){
        if(minnu[i]>sumfood[i]){
            return false;
        }
    }
    return true;
}*/
int main(){
    /*ifstream instream("diet.inp");
    ofstream outstream("diet.out");
    instream>>N;
    vector<int> minnu;
    vector<vector<int>> food(N, vector<int> (5,0));
    for(int i=0;i<4;i++){
        int a;
        instream>>a;
        minnu.push_back(a);
    }
    for(int i=0;i<N;i++){
        for(int m=0;m<5;m++){
            int a;
            instream>>a;
            food[i][m]=a;
        }
    }
    vector<int> ans(N,0);
    vector<int> sumfood(4,0);
    int backtrackmoney =0;
    int minmoney =10000;
    vector<vector<int>> ans2(N, vector<int> (N,0));
    vector<int>check;
    int a=0;
    bool s;
    backtracking(ans,N-1);
    bool che=true;
    while(che){
        check.clear();
        int start = N-1;
        backtrackmoney=0;
        for(int i=0;i<4;i++){
            sumfood[i]=0;
        }
       for(int i=0;i<N;i++){
            if(ans[i]==1){
                for(int m=0;m<4;m++){
                    sumfood[m]=sumfood[m]+food[i][m];
                }
                backtrackmoney=backtrackmoney+food[i][4];
            }
            if(backtrackmoney>minmoney){
                if(backtracking(ans,i)){
                    che=true;
                }
                else{
                    che=false;
                }
                start=0;
                break;
            }
            else if(backtrackmoney==minmoney){
                start=i;
                for(int m=i+1;m<N;m++){
                    if(ans[m]==1&&food[m][4]!=0){
                        backtrackmoney=backtrackmoney+12412;
                        backtracking(ans,start);
                    }
                }
            }
       }

       if(backtrackmoney<=minmoney){
           if(checkfood(sumfood,minnu)){
                if(backtrackmoney==minmoney){
                    minmoney = backtrackmoney;
                    ans2.push_back(ans);
                    if(backtracking(ans,start)){
                        che=true;
                    }
                    else{
                        che=false;
                    }
                }
                else if(backtrackmoney<minmoney){
                    minmoney = backtrackmoney;
                    ans2.clear();
                    ans2.push_back(ans);
                    if(backtracking(ans,N-1)){
                            che=true;
                    }
                    else{
                        che=false;
                    }
                }
           }
           else{
                backtracking(ans,N-1);
           }
       }
       if(che==false){
            break;
       }
    }
    sort(ans2.rbegin(),ans2.rend());
    for(int i=0;i<N;i++){
        if(ans2[0][i]==1){
            outstream<<i+1<<" ";
        }
    }
    instream.close();
    outstream.close();*/
    long long a;
    a = 1*pow(10,8);
    cout<<a<<endl;

}
