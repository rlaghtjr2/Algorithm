#include <bits/stdc++.h>
using namespace std;
int N,k,i,m,time_m,custom_m,num,coun;
void minimum(queue<int> *timesum,int k,int *time_m,int *custom_m,int *num){
    int i;
    *time_m=timesum[0].back();
    *num=0;
    for(i=1;i<k;i++){
        if(timesum[i].back()<*time_m){
            *time_m=timesum[i].back();
            *num=i;
        }
    }
}
void add(queue<int> *timesum,queue<int> counter[0],int num,vector<int> custom, vector <int>time, int *coun){
    int sum;
    sum=timesum[num].back()+time[*coun];
    timesum[num].push(sum);
    counter[num].push(custom[*coun]);
    *coun+=1;
}
void printmin(queue<int> *timesum,queue<int> counter[0],int k,int *time_m,int *custom_m,int *num){
    int i;
    //*time_m=timesum[0].front();
    for(i=0;i<k;i++){
        if(!timesum[i].empty()){
            *time_m=timesum[i].front();
            break;
        }
    }
    *num=0;
    for(i=1;i<k;i++){
        if(timesum[i].empty()){
            continue;
        }
        else if(timesum[i].front()<=*time_m){
            *time_m=timesum[i].front();
            *num=i;
        }
    }
}
int main(){
    ifstream instream("3.inp");
    instream>>N>>k;
    vector <int> custom;
    vector <int> time;
    queue <int> counter[k];
    queue <int> timesum[k];
    for(i=0;i<N;i++){
        instream >> m;
        custom.push_back(m);
        instream >> m;
        time.push_back(m);
    }//vector만들기.
    instream.close();//in파일 닫기
    ofstream outstream;//출력파일 생성
    outstream.open("shopping.out");
    if(k<N){
    for(i=0;i<k;i++){
        counter[i].push(custom[i]);
        timesum[i].push(time[i]);
        }
    }
    else{
        for(i=0;i<N;i++){
        counter[i].push(custom[i]);
        timesum[i].push(time[i]);
        }
    }
    if(N<k){
        for(i=0;i<N;i++){
            printmin(timesum,counter,k,&time_m,&custom_m,&num);
            outstream<<counter[num].front()<<endl;
            timesum[num].pop();
            counter[num].pop();
        }
    }
    else{
        coun=k;
        for(i=coun;i<N;i++){
            minimum(timesum,k,&time_m,&custom_m,&num);
            add(timesum,counter,num,custom,time, &coun);
        }
        for(i=0;i<N;i++){
            printmin(timesum,counter,k,&time_m,&custom_m,&num);
            outstream<<counter[num].front()<<endl;
            timesum[num].pop();
            counter[num].pop();
        }
    }
    outstream.close();//out파일 닫
}

