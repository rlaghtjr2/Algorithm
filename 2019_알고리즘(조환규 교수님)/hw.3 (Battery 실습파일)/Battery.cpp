#include <bits/stdc++.h>
using namespace std;
int n,z,w,num,maxdis;
queue<int> queCd;

float dis(int a, int b, int c ,int d){
    float dis = sqrt(pow((c-a),2)+pow((d-b),2));
    return dis;
}
float check(vector<vector<int>> vecCd){
    queue<int> queCd;
    vector<int> checkvec;
    int breaking,qfront;
    int mini=0;
    int maxi=vecCd[vecCd.size()-1][0];
    float priviousmin =0;
    float prians;
    float ans = dis(0,0,vecCd[vecCd.size()-1][0],vecCd[vecCd.size()-1][1])/2;
    float priviousmax = ans*2;
    float mindis=dis(0,0,vecCd[0][0],vecCd[0][1]);
    for(int i = 1; i<vecCd.size();i++){
        if(mindis>dis(0,0,vecCd[i][0],vecCd[i][1]))
            mindis=dis(0,0,vecCd[i][0],vecCd[i][1]);
    }
    while(true){
        breaking=0;
            for(int i = 0;i <vecCd.size() ; i++){
                if(dis(0,0,vecCd[i][0],vecCd[i][1])<=ans){
                    queCd.push(i);
                    checkvec.push_back(1);
                }
                else
                    checkvec.push_back(0);
            }
            int quesize = queCd.size();
            while(!queCd.empty()){
                for(int i =0; i<queCd.size();i++){
                    qfront=queCd.front();
                    for(int m = 0; m<vecCd.size();m++){
                        if(dis(vecCd[qfront][0],vecCd[qfront][1],vecCd[m][0],vecCd[m][1])<=ans&&checkvec[m]!=1&&qfront!=m){
                            queCd.push(m);
                            checkvec[m]=1;
                            if(m==vecCd.size()-1){
                                breaking=1;
                            }
                        }
                        if(breaking==1)
                            break;
                    }
                    queCd.pop();
                    if(breaking==1)
                        break;
                }
                if(breaking==1)
                    break;
            }
            if(ans>=mindis){
                if(!queCd.empty()){
                    priviousmax=ans;
                    prians=ans;
                    ans=(priviousmin+priviousmax)/2;
                }
                else if(queCd.empty()){
                    priviousmin=ans;
                    prians=ans;
                    ans=(priviousmin+priviousmax)/2;
                }
        }
        else{
            priviousmin=ans;
            prians=ans;
            ans=(priviousmin+priviousmax)/2;
        }
        while(!queCd.empty()){
            queCd.pop();
        }
        checkvec.clear();
        if(ans>prians){
            if(ans-prians<0.00001)
                break;
        }
        if(prians>ans){
            if(prians-ans<0.00001)
                break;
        }
        if(priviousmax-priviousmin<0.001){
            break;
        }
        if(prians==ans)
            break;
    }
    return ans;
}

int main(){
    ifstream instream("Battery.inp");
    ofstream outstream("Battery.out");
    instream>>n>>z;
    vector< vector<int>> vecCd(n+1, vector<int> (3,0));
    for(int i=0;i<n;i++){
        for(int m=0;m<2;m++){
            instream>>num;
            vecCd[i][m]=num;
        }
        vecCd[i][2]=0;
    }
    vecCd[n][0]=vecCd[n][1]=z;
    vecCd[n][2]=0;
    outstream<<ceil(floor(check(vecCd)*100000)/100000);

    instream.close();
    outstream.close();
}
