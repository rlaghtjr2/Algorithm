#include <bits/stdc++.h>
using namespace std;
int N,siz,m;
int timer=0;
int chk(vector<vector<string>>&v2,string a){
    for(int i=0;i<v2[0].size();i++){
        if(a==v2[0][i]){
            return i;
            break;
        }
    }
}
void ftime(vector<vector<string>>&v,vector<vector<string>>&v2,queue<string>&q1,vector<vector<int>>&time){
    for(int i=0;i<N;i++){
        siz=q1.size();
        for(int z=0;z<siz;z++){
            for(m=0;m<N;m++){
                if(v[m][0]==q1.front()){
                    break;
                }
            }
            for(int t=1;t<v[m].size();t++){
                if(v2[1][chk(v2,v[m][t])]=="0"){
                    q1.push(v[m][t]);
                    v2[1][chk(v2,v[m][t])]="1";
                    if(time[1][m]==0){
                        time[1][chk(v2,v[m][t])]=time[1][m]+1;
                    }
                    else if(time[1][m]!=0){
                        if(v[chk(v2,v[m][t])].size()!=1){
                            time[1][chk(v2,v[m][t])]=time[1][m]+3;
                        }
                        else{
                            time[1][chk(v2,v[m][t])]=time[1][m]+1;
                        }
                    }
                }
            }
            q1.pop();
        }
    }
}
string one,two,three,ch;
int main(){
ifstream instream ("meeting.inp");
ofstream outstream("meeting.out");
instream>>N>>one>>two>>three;
vector<vector<string>> v(N,vector<string>(0));
queue<string> q1;
vector<vector<string>> v2(2,vector<string>(0));
vector<vector<int>> time(2,vector<int>(N,0));
vector<vector<int>> time2(2,vector<int>(N,0));
vector<vector<int>> time3(2,vector<int>(N,0));
vector<vector<int>> time4(N,vector<int>(2,0));
for(int i=0;i<N;i++){
    instream>>ch;
    while(ch!="$"){
        v[i].push_back(ch);
        instream>>ch;
    }
}
for(int i=0;i<N;i++){
    v2[0].push_back(v[i][0]);
}
for(int i=0;i<N;i++){
    v2[1].push_back("0");
}
q1.push(one);
v2[1][chk(v2,one)]="1";
/*for(int i=0;i<N;i++){
    siz=q1.size();
    for(int z=0;z<siz;z++){
        for(m=0;m<N;m++){
            if(v[m][0]==q1.front()){
                break;
            }
        }
        for(int t=1;t<v[m].size();t++){
            if(v2[1][chk(v2,v[m][t])]=="0"){
                q1.push(v[m][t]);
                v2[1][chk(v2,v[m][t])]="1";
                if(time[1][m]==0){
                    time[1][chk(v2,v[m][t])]=time[1][m]+1;
                }
                else if(time[1][m]!=0){
                    if(v[chk(v2,v[m][t])].size()!=1){
                        time[1][chk(v2,v[m][t])]=time[1][m]+3;
                    }
                    else{
                        time[1][chk(v2,v[m][t])]=time[1][m]+1;
                    }
                }
            }
        }
        q1.pop();
    }
    cout<<"Queue :"<<endl;
    while(!q1.empty()){
        cout<<q1.front()<<" ";
        q2.push(q1.front());
        q1.pop();
    }
        cout<<endl;
        q1=q2;
}
/*for(int i=0;i<N;i++){
    for(int m=0;m<v[i].size();m++){
        cout<<v[i][m]<<" ";
    }
    cout<<endl;
}*/
ftime(v,v2,q1,time);
for(int i=0;i<N;i++){
    v2[1][i]="0";
}
q1.push(two);
v2[1][chk(v2,two)]="1";
ftime(v,v2,q1,time2);
for(int i=0;i<N;i++){
    v2[1][i]="0";
}
q1.push(three);
v2[1][chk(v2,three)]="1";
ftime(v,v2,q1,time3);

for(int i=0;i<N;i++){
    int maximum=time[1][i];
    if(maximum<time2[1][i]){
        maximum=time2[1][i];
    }
    if(maximum<time3[1][i]){
        maximum=time3[1][i];
    }
    time4[i][0]=maximum;
    time4[i][1]=i;
}

/*cout<<endl;
for(int i=0;i<N;i++){
    cout<<v2[0][i]<<" ";
}
cout<<endl;
for(int i=0;i<N;i++){
    cout<<time[1][i]<<" ";
}
cout<<endl;
for(int i=0;i<N;i++){
    cout<<time2[1][i]<<" ";
}
cout<<endl;
for(int i=0;i<N;i++){
    cout<<time3[1][i]<<" ";
}
cout<<endl;
sort(time4.begin(),time4.end());
for(int i=0;i<N;i++){
        for(int m=0;m<2;m++){
            cout<<time4[i][m]<<" ";
        }
        cout<<endl;
}*/
sort(time4.begin(),time4.end());
if(time4[0][0]!=time4[1][0]){
    outstream<<v2[0][time4[0][1]]<<endl;
    outstream<<time4[0][0];
}
if(time4[0][0]==time4[1][0]&&time4[0][0]!=time4[N-1][0]){
    int k=0;
    while(time4[k][0]==time4[k+1][0]){
        k++;
    }
    vector<string> z;
    for(int i=0;i<k;i++){
        z.push_back(v2[0][time4[i][1]]);

    }
    sort(z.begin(),z.end());
    outstream<<z[0]<<endl;
    outstream<<time4[0][0];
}
if(time4[0][0]==time4[N-1][0]){
    vector<string> z;
    for(int i=0;i<N;i++){
        z.push_back(v2[0][time4[i][1]]);

    }
    sort(z.begin(),z.end());
    outstream<<z[0]<<endl;
    outstream<<time4[0][0];
}
outstream.close();
instream.close();
}
