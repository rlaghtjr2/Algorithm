#include <bits/stdc++.h>
using namespace std;
int k1,k2,fun,i,m,num,a,b,top,top2,bro,sis,bro1,bro2,sis1,sis2,popo,titi;
double n;
int k=0;
int l=1;
int stop=0;
double sizesum,counting=0;
string p;
void add(vector<vector<string>>v1,vector<string>v2,stack<int>&v3,stack<int>&numb,double *counting,double N, int *k, int *l,int k1, int k2,int *stop,int *bro1,int *bro2,int *sis1,int *sis2,int *a, int *titi){
    int i,m,p,q,r;
    if(*k==0&&*l==v1[0].size()){
        *titi=0;
    }
    else if(*k!=0&&*l==v1[*k].size()){
        *k=v3.top();
        *l=numb.top();
        v3.pop();
        numb.pop();
    }
    for(i=*l;i<v1[*k].size();i++){
        for(m=0;m<N;m++){
            if(v1[*k][i]!=v2[m]){
                *titi=*k;
                *counting=(*counting+(double)(1/N));
                if(ceil(*counting)==k1){
                    *bro1=*k;
                    *bro2=i;
                }
                else if(ceil(*counting)==k2){
                    *sis1=*k;
                    *sis2=i;
                }
            }
            else if(v1[*k][i]==v2[m]){
                *a=m;
                v3.push(*k);
                numb.push(i+1);
                break;
                }
            }//�ٸ� �빮���Լ��� ���������� ����, ������ �Ǹ� �� �ּҰ��� ������ �����ϰ� �� ��ȣ�� stack�� ����.

        if(v1[*k][i]==v2[*a]){
            *k=*a;
            *l=1;
            *counting=(int)*counting;
            break;
        } //������ �Ǹ� k�� �����Լ� �����Ҷ� ��� �ϴ��� k�� l�� �����ϰ�, ī��Ʈ�� int���·� ����� �� ��, ����
    }
    if(i==v1[*titi].size()){
        if(*titi!=0){
            *k=v3.top();
            *l=numb.top();
            v3.pop();
            numb.pop();
        }
        else{
            *stop=1;
            *counting=(int)*counting;
        }
    }
} //������ ������ , M�Լ��� �ƴϸ� stack���� �̾� k��l�� �ְ�, M�Լ��϶� stop=1����.
int main(){
    ifstream instream("function.inp");
    instream >> n >> k1 >> k2;
    vector< vector<string> > v1(n, vector<string>(0));
    vector<string> v2(n);
    stack <int> v3;
    stack <int> numb;
    for(i=0;i<n;i++){
        for(m=0;;m++){
            instream>>p;
            if(p!="$"){
                v1[i].push_back(p);
            }
            else
                break;
        }
    } //v1���� �����(v1=��ü ����)
    for(i=0;i<n;i++){
        v2[i]=v1[i][0];
    }//v2���� �����(v2=�Լ�����)
    instream.close();//in���� �ݱ�
    ofstream outstream;//������� ����
    outstream.open("function.out");
    add(v1,v2,v3,numb,&counting,n,&k,&l,k1,k2,&stop,&bro1,&bro2,&sis1,&sis2,&a,&titi);
    if(stop!=1){
    while(n<100){
        a=k;
        b=l;
        add(v1,v2,v3,numb,&counting,n,&k,&l,k1,k2,&stop,&bro1,&bro2,&sis1,&sis2,&a,&titi);
        //cout<<"count : "<<counting<<" �� : "<<v1[k][l]<<" k�� : "<<k << " l�� : "<<l<<endl;
        if(stop==1){
            break;
        }
    stack<int> temp;
    while (!v3.empty()) {
        top = v3.top(); v3.pop();
        temp.push(top);
        if(k==top&&l==1){
            bro=top;
            break;
        }
    }
    while (!temp.empty()) {
        top = temp.top(); temp.pop();
        v3.push(top);
    }
    if(k==bro&&l==1){
        outstream<<"DEADLOCK"<<'\n';
        popo=1;
        break;
        }
    }
    }
    if(popo!=1){
        if(k1<=counting&&k1>0){
            outstream<<v1[bro1][0]<<"-"<<v1[bro1][bro2]<<'\n';
        }
        else{
            outstream<<"NONE"<<'\n';
            }
        if(k2<=counting&&k2>0){
            outstream<<v1[sis1][0]<<"-"<<v1[sis1][sis2]<<'\n';
        }
        else{
            outstream<<"NONE"<<'\n';
            }
    }
    outstream.close();//out���� ��
}
