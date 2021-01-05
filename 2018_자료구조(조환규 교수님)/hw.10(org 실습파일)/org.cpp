#include <bits/stdc++.h>
using namespace std;
int N,i,m,z,x,co,star;
string str,str1,roote;
int main(){
    ifstream instream("org.inp");
    ofstream outstream("org.out");
    instream>>N;
    vector< vector<string> > treevec(2,vector<string>(0));
    vector<string> root;
    vector<int> sub(N-1,0);
    vector<int> sub2(N-1,0);
    vector<vector<int>> sum(N-1,vector<int>(2,0));
    vector<string> v;
    vector<string> v2;
    vector<string> next;
    vector<string> next2;
    vector<string> v4;
    vector<string> v5;
    for(i=1;i<N;i++){ //주의 1부터 넣었음.
        instream>>str>>str1;
        treevec[0].push_back(str);
        treevec[1].push_back(str1);
    }
    for(i=0;i<N-1;i++){
        auto iter = find(treevec[1].begin(), treevec[1].end(),treevec[0][i]);
        auto iter2 = find(treevec[0].begin(), treevec[0].end(),treevec[1][i]);
        if(iter==treevec[1].end()){
            root.push_back(treevec[0][i]);
        }
        if(iter2==treevec[0].end()){
            roote=treevec[1][i];
        }
    } //leaf 찾아서 root벡터에 넣기.->leaf벡터로 해야되는데 잘못이름넣음 root벡터 == leaf들 모임임.
    next2=root;
    co=1;
    while(!next2.empty()){
    for(i=0;i<next2.size();i++){
        for(m=0;m<N-1;m++){
            if(treevec[0][m]==next2[i]){
                    for(z=0;z<N-1;z++){
                        if(treevec[1][m]==treevec[0][z]){
                            if(sub[m]==0){
                                sub[z]+=1;}
                            else
                                sub[z]=sub[z]+sub[m]+1;
                            auto it = find(next.begin(),next.end(),treevec[1][m]);
                            if(it==next.end()){
                                next.push_back(treevec[1][m]);
                            }
                        }
                    }
            }
        }
    }
    next2.clear();
    next2=next;
    next.clear();
    for(i=0;i<N-1;i++){
        str=treevec[0][i];
        str1=treevec[1][i];
        for(m=0;m<next2.size();m++){
            if(str==next2[m]){
                for(z=0;z<next2.size();z++){
                    if(str1==next2[z]){
                        auto it=find(next2.begin(),next2.end(),next2[z]);
                        next2.erase(it);
                    }
                }
            }
        }
    }
    } //sub에 조건1인 부하직원수를 넣는 알고리즘.

    v.push_back(roote);
    while(!v.empty()){
    for(i=0;i<v.size();i++){
        for(m=0;m<N-1;m++){
            if(v[i]==treevec[1][m]){
                sub2[m]=co;
                v2.push_back(treevec[0][m]);
            }
        }
    }
    v.clear();
    v=v2;
    v2.clear();
    co++;
    }//sub2에 root와 거리수를 넣는 알고리즘.

    for(i=0;i<N-1;i++){
        sum[i][1]=i;
        sum[i][0]=sub[i]*1000-sub2[i]*10;
    } //sum에 sub에있는 부하직원수 *1000 - sub2에있는 root와의 거리수*10 을 해서 점수를 나타냄.
    sort(sum.rbegin(),sum.rend()); //점수에따라 sort를함.
    outstream<<roote<<" "; //root출력.
    i=0;
    while(i<N-2){
    for(i;i<N-1;i++){
        if(i!=N-2){
        if(sum[i][0]!=sum[i+1][0]){
            outstream<<treevec[0][sum[i][1]]<<" ";
        }
        else{
            break;
        }
        }
        else if(i==N-2){
            outstream<<treevec[0][sum[i][1]]<<" ";
        }
    }
    if(i==N-1){
        break;
    }
    m=i;
    while(sum[i][0]==sum[i+1][0]){
        i++;
        if(i==N-2){
            break;
        }
    }
    for(int star=m;star<i+1;star++){
        v4.push_back(treevec[0][sum[star][1]]);
        sort(v4.begin(),v4.end());
    }
    for(int q=0; q<v4.size();q++){
        outstream<<v4[q]<<" ";
    }
    i++;
    v4.clear();
    } //sum에있는 점수순으로 출력을함.점수가 그다음것과 똑같은게있으면 v4인 벡터에 넣어서, v4를 sort해서 이름순으로 출력, 그리고 다시 처음으로 돌아감.
    instream.close();
    outstream.close();
}
