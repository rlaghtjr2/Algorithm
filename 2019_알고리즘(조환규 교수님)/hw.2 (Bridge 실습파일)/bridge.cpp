#include <bits/stdc++.h>
using namespace std;
int Ax,Ay,Az,Bx,By,Bz,Px,Py,Pz;
vector<float> a,b,p,v1,v2;
float N;
float mindis,Adis,Bdis;
float dis(vector<float> &a, vector<float> &b){
    float dis = sqrt(pow((a[0]+a[3])/2-b[0],2)+pow((a[1]+a[4])/2-b[1],2)+pow((a[2]+a[5])/2-b[2],2));
    return dis;
}
int main(){
    ifstream instream("bridge.inp");
    ofstream outstream("bridge.out");
    for(int i=0;i<9;i++){
        instream>>N;
        if(i<6){
            a.push_back(N);
            b.push_back(N);
        }
        else
            p.push_back(N);
    }
    mindis=dis(a,p);
    for(int i=3;i<6;i++){
        a[i]=(a[i]+a[i-3])/2;
        b[i-3]=(b[i-3]+b[i])/2;
    }
    while(true){
        Adis=dis(a,p);
        Bdis=dis(b,p);
        if(Adis==Bdis){
            outstream<<ceil(mindis)<<endl;
            break;
        }
        else if(Adis!=Bdis){
            if(Adis<Bdis){
                mindis=Adis;
                b=a;
                for(int i=3;i<6;i++){
                    a[i]=(a[i]+a[i-3])/2;
                    b[i-3]=(b[i-3]+b[i])/2;
                }
            }
            else if(Adis>Bdis){
                mindis=Bdis;
                a=b;
                for(int i=3;i<6;i++){
                    a[i]=(a[i]+a[i-3])/2;
                    b[i-3]=(b[i-3]+b[i])/2;
                }
            }
        }
        else if(Adis==mindis||Bdis==mindis){
            outstream<<ceil(mindis)<<endl;
            break;
        }
        if(Adis>mindis&&Bdis>mindis){
            outstream<<ceil(mindis)<<endl;
            break;
        }
    }
    instream.close();
    outstream.close();
}
