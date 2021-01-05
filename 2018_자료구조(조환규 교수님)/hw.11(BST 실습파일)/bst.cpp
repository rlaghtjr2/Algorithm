#include <bits/stdc++.h>
using namespace std;
int N,i,dep;
string str;
ofstream outstream("bst.out");
void add(vector<string>&bst,string str){
    int k=1;
    while(bst[k]!="0"){
        int compar=bst[k].compare(str);
        if(compar>0){
            k=k*2;
        }
        else if(compar<0){
            k=k*2+1;
        }
        else if(compar==0){
            k=-1;
            break;
        }
    }
    if(k!=-1){
        bst[k]=str;
    }
}
int serch(vector<string>bst,string str){
    int m,k;
    for(int i=0;i<500000;i++){
       if(bst[i]==str){
            if(bst[2*i]!="0"){
                m=2*i;
                k=m;
                while(bst[m*2+1]!="0"){
                    if(bst[m*2+1]!="0"){
                            m=m*2+1;
                            k=m;
                    }
                }
            } //좌측 부트리가 0이아닐때.
            else if(bst[2*i]=="0"){
                if(bst[2*i+1]=="0"){
                    k=i;
                }
                else{
                    m=2*i+1;
                    k=m;
                    while(bst[m*2]!="0"){
                        if(bst[m*2]!="0"){
                            m=m*2;
                            k=m;
                        }
                    }
                }
            }//좌측 부트리없을때.
            break;
            }
       }
    return k;
}
void del(vector<string>&bst,string str){
    int k,m;
    auto it=find(bst.begin(),bst.end(),str);
    if(it!=bst.end()){
        k=serch(bst,str);
        m=serch(bst,bst[k]);
        *it=bst[k];
        bst[k]=bst[m];
        bst[m]="0";
    }
}
void depth(vector<string>bst,int depth){
    int co=0;
    for(int i=pow(2,depth-1);i<pow(2,depth);i++){
        if(bst[i]!="0"){
            outstream<<bst[i]<<" ";
        }
        else if(bst[i]=="0"){
            co++;
        }
    }
    if(co==pow(2,depth-1)){
        outstream<<"NO";
    }
    else if(bst[1]=="0"){
        outstream<<"NO";
    }
    outstream<<"\n";
}
void leaf(vector<string>bst){
    if(bst[2]=="0"&&bst[3]=="0"){
        outstream<<bst[1]<<" ";
    }
    else if(bst[2]!="0"||bst[3]!="0"){
        for(int i=1;i<500000;i++){
            if(bst[i*2]=="0"&&bst[i*2+1]=="0"&&bst[i]!="0"){
                outstream<<bst[i]<<" ";
            }
        }
    }
    outstream<<"\n";
}
int main(){
    ifstream instream("bst.inp");
    instream>>N;
    vector<string> bst(1000000,"0");
    for(i=0;i<N;i++){
        instream>>str;
        if(str=="+"){
            instream>>str;
            add(bst,str);
        }
        else if(str=="-"){
            instream>>str;
            if(bst[1]!="0"){
                del(bst,str);
            }
        }
        else if(str=="depth"){
            instream>>dep;
            depth(bst,dep);
        }
        else if(str=="leaf"){
            leaf(bst);
        }
    }
    instream.close();
    outstream.close();
}
