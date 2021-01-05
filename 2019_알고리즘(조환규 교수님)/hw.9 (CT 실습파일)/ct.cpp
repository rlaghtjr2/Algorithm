#include <bits/stdc++.h>
using namespace std;
int N,a;
void backtrack(vector<vector<string>> &ans,int q){
        int num=-1;
        for(int i=0;i<N;i++){
            if(ans[q][i]=="B"){
                num=i;
            }
            else
                continue;
        }
        if(num==-1){
            return ;
        }
        else if(num!=N-1){
            ans[q][num]="-";
            ans[q][num+1]="B";
        }
        else if(num==N-1){
            int Bnum=1;
            int p;
            for(int i=num-1;i>=0;i--){
                if(ans[q][i]=="B"&&ans[q][i+1]=="-"){
                    ans[q][i]="-";
                    ans[q][i+1]="B";
                    p=i+2;
                    break;
                }
                if(ans[q][i]=="B"&&ans[q][i+1]=="B"){
                    Bnum++;
                }
            }
            for(int a=0;a<Bnum;a++){
                ans[q][p]="B";
                p++;
            }
            for(int r=p;r<N;r++){
                ans[q][r]="-";
            }
        }

}
int combi(int a, int b){
    int c=a;
    for(int i=1;i<b;i++){
        c=c*(a-i);
    }
    for(int i=1;i<=b;i++){
        c=c/i;
    }
    return c;
}
int checkback(vector<int> down, vector<int> rightdown, vector<int> leftdown, vector<vector<string>> ans,int checkcol){
    for(int i=0;i<N;i++){
        int num=0;
        for(int m=0;m<N;m++){
            if(ans[m][i]=="B"){
                num++;
            }
        }
        if(num>down[i]){
            return 0;
        }
    }
    int c=0;
    for(int i=N-1;i>=0;i--){
        int a=0;
        int num=0;
        int b=i;
        while(b!=N){
            if(ans[a][b]=="B"){
                num++;
            }
            a++;
            b++;
        }
        if(rightdown[c]<num){
            return 0;
        }
        c++;
    }
    for(int i=1;i<N;i++){
        int a=i;
        int num=0;
        int b=0;
        while(a!=N){
            if(ans[a][b]=="B"){
                num++;
            }
            a++;
            b++;
        }
        if(rightdown[c]<num){
            return 0;
        }
        c++;
    }
    c=0;
    for(int i=0;i<N;i++){
        int b=i;
        int a=0;
        int num=0;
        while(b!=-1){
            if(ans[a][b]=="B"){
                num++;
            }
            a++;
            b--;
        }
        if(leftdown[c]<num){
            return 0;
        }
        c++;
    }
    for(int i=1;i<N;i++){
        int a=i;
        int b=N-1;
        int num=0;
        while(a!=N){
            if(ans[a][b]=="B"){
                num++;
            }
            a++;
            b--;
        }
        if(leftdown[c]<num){
            return 0;
        }
        c++;
    }
    bool stopp;
    while(true){
        int stopp2=0;
        stopp=false;
        queue<int> col,row;
        for(int i=1;i<N-1;i++){
            for(int m=1;m<N-1;m++){
                if(ans[i][m]=="-"){
                    col.push(i);
                    row.push(m);
                    stopp=true;
                    ans[i][m]="+";
                    break;
                }
            }
            if(stopp)
                break;
        }
        if(col.empty()){
            break;
        }
        while(!col.empty()){
            int a=col.front();
            int b=row.front();
            if(a<N-1){
                if(ans[a+1][b]=="-"){
                    ans[a+1][b]="+";
                    col.push(a+1);
                    row.push(b);
                    }
            }
            if(a>0){
                if(ans[a-1][b]=="-"){
                    ans[a-1][b]="+";
                    col.push(a-1);
                    row.push(b);
                    }
            }
            if(b<N-1){
                if(ans[a][b+1]=="-"){
                    ans[a][b+1]="+";
                    col.push(a);
                    row.push(b+1);
                    }
            }
            if(b>0){
                if(ans[a][b-1]=="-"){
                    ans[a][b-1]="+";
                    col.push(a);
                    row.push(b-1);
                    }
            }
            col.pop();
            row.pop();
            if(col.empty()){
                break;
            }
            else if(!col.empty()&&col.front()==N-1||col.front()==0||row.front()==N-1||row.front()==0){
                stopp2=1;
            }
        }
        if(stopp2==0){
            return 0;
        }
    }
    if(checkcol==N-1){
        bool stopp2=false;
        queue<int> col,row;
        for(int i=0;i<N;i++){
            for(int m=0;m<N;m++){
                if(ans[i][m]=="B"){
                    col.push(i);
                    row.push(m);
                    ans[i][m]="A";
                    stopp2 = true;
                    break;
                }
            }
            if(stopp2)
                break;
        }
        while(!col.empty()){
            int a=col.front();
            int b=row.front();
            if(a<N-1){
                if(ans[a+1][b]=="B"){
                    ans[a+1][b]="A";
                    col.push(a+1);
                    row.push(b);
                }
            }
            if(a>0){
                if(ans[a-1][b]=="B"){
                    ans[a-1][b]="A";
                    col.push(a-1);
                    row.push(b);
                }
            }
            if(b<N-1){
                if(ans[a][b+1]=="B"){
                    ans[a][b+1]="A";
                    col.push(a);
                    row.push(b+1);
                }
            }
            if(b>0){
                if(ans[a][b-1]=="B"){
                    ans[a][b-1]="A";
                    col.push(a);
                    row.push(b-1);
                }
            }
            col.pop();
            row.pop();
            if(col.empty()){
                break;
            }
        }
        for(int i=0;i<N;i++){
            for(int m=0;m<N;m++){
                if(ans[i][m]=="B"){
                    return 0;
                }
            }
        }
    }
    return 1;
}
int main(){
    ifstream instream("ct.inp");
    ofstream outstream("ct.out");
    instream>>N;
    vector<int> down,right,rightdown,leftdown;
    vector< vector<string>> ans(N, vector<string> (N,"-"));
    vector< vector<string>> ans2(N, vector<string> (N,"-"));
    for(int i=0;i<N;i++){
        instream>>a;
        down.push_back(a);
    }
    for(int i=0;i<N;i++){
        instream>>a;
        right.push_back(a);
    }
    for(int i=0;i<N*2-1;i++){
        instream>>a;
        rightdown.push_back(a);
    }
    for(int i=0;i<N*2-1;i++){
        instream>>a;
        leftdown.push_back(a);
    }
    for(int i=0;i<N;i++){
        for(int m=0;m<right[i];m++){
            ans[i][m]="B";
        }
        for(int m=right[i];m<N;m++){
            ans[i][m]="-";
        }
    }
    vector<vector<string>>ans3;
    ans3=ans;
    for(int i=0;i<N;i++){
        for(int m=0;m<combi(N,right[i])-1;m++){
            backtrack(ans,i);
        }
    }
    vector<string> minuss;
    for(int i=0;i<N;i++){
        minuss.push_back("-");
    }
    int a=0;
    for(int i=0; i<N; i++){
        if(a==0){
            ans2[i] = ans3[i];
        }
        if(checkback(down,rightdown,leftdown,ans2,i)==0){

            if(ans2[i]!=ans[i]){
                backtrack(ans2,i);
                i=i-1;
                a=1;
            }
            else{
                int m;
                for(m=i;m>0;m--){
                    ans2[m]=minuss;
                    if(ans2[m-1]==ans[m-1]){
                        continue;
                    }
                    else{
                        break;
                    }
                }
                i=m-2;
                a=1;
                backtrack(ans2,i+1);
            }
        }
        else{
            a=0;
        }
    }
    for(int i=0;i<N;i++){
        for(int m=0;m<N;m++){
           cout<<ans2[i][m]<<" ";
        }
        cout<<endl;
    }
    instream.close();
    outstream.close();
}
