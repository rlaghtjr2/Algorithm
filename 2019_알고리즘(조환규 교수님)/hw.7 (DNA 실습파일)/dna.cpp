#include <bits/stdc++.h>
using namespace std;
string a,b;
queue<int> rowque;
queue<int> colque;
queue<string> strque;
int maxim(int a, int b, int c, int d){
    int maxi = a;
    if(b>maxi)
        maxi=b;
    if(c>maxi)
        maxi=c;
    if(d>maxi)
        maxi=d;
    return maxi;
}
int main(){
    ifstream instream("1.inp");
    ofstream outstream("dna.out");
    instream>>a>>b;
    vector<char>a1;
    vector<char>b1;
    for(int i=0;i<a.length();i++){
        a1.push_back(a[i]);
    }
    for(int i=0;i<b.length();i++){
        b1.push_back(b[i]);
    }
    vector<vector<int>> check(b.length()+1,vector<int>(a.length()+1,0));
    vector<vector<string>> sol(b.length()+1,vector<string>(a.length()+1,""));
    for(int i=0;i<a1.size();i++){
        int e=0;
        if(a1[i]==b1[0]){
            e=1;
        }
        check[1][i+1]=e;
    }
    for(int i=0;i<b1.size();i++){
        int e=0;
        if(b1[i]==a1[0]){
            e=1;
        }
        check[i+1][1]=e;
    }
    int maxi=0;
    for(int i=1;i<b1.size();i++){
        for(int m=1;m<a1.size();m++){
            if(b1[i]==a1[m]){
                check[i+1][m+1]=maxim(check[i-1][m-1],check[i-1][m],check[i][m-1],check[i][m])+1;
                if(check[i+1][m+1]>maxi){
                    maxi=check[i+1][m+1];
                }
            }
            else{
                    check[i+1][m+1]=0;
            }
        }
    }
    for(int i=0;i<b1.size()+1;i++){
        for(int m=0;m<a1.size()+1;m++){
            if(check[i][m]==maxi){
                rowque.push(i);
                colque.push(m);
                strque.push("");
            }
        }
    }
    vector<string>test;
    sol[rowque.front()][colque.front()]=b1[colque.front()-1];
    while(!rowque.empty()){
        int counting=0;
        int row = rowque.front();
        int col = colque.front();
        string t = b1[rowque.front()-1]+strque.front();
        rowque.pop();
        colque.pop();
        strque.pop();
        if(t.length()==maxi){
            test.push_back(t);
        }
        else{
            for(int i=row-2;i<row;i++){
                for(int m=col-2;m<col;m++){
                    if(check[i][m]>counting){
                        counting=check[i][m];
                    }
                }
            }
            for(int i=row-2;i<row;i++){
                for(int m=col-2;m<col;m++){
                    if(check[i][m]==counting&&counting!=0){
                        rowque.push(i);
                        colque.push(m);
                        strque.push(t);
                    }
                }
            }
        }
    }
    string q=test[0];
    for(int i=1; i<test.size();i++){
        if(q.compare(test[i])==1){
            q=test[i];
        }
    }
    outstream<<q<<endl;
     for(int i=0;i<b1.size()+1;i++){
        for(int m=0;m<a1.size()+1;m++){
            cout<<check[i][m]<<" ";
        }
        cout<<endl;
    }
    //cout<<"answ:"<<q<<endl;
    instream.close();
    outstream.close();
}
