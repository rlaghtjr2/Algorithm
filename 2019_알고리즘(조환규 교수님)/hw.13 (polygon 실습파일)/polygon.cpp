#include <bits/stdc++.h>
using namespace std;
int N;
int signedarea(int x1, int y1, int x2, int y2, int x3, int y3){
    int a = x1*y2 + x2*y3+ x3*y1;
    a= a - (y1*x2+y2*x3+y3*x1);
    if(a>0)
        return 1; //반시계
    else if(a==0)
        return 0; // 직선
    else if(a<0)
        return -1;
}

int main(){
    int clock=0;
    int reverseclock =0;
    ifstream instream("polygon.inp");
    ofstream outstream("polygon.out");
    instream>>N;
    vector< vector<int>> pol(N, vector<int> (2,0));
    for(int i=0;i<N;i++){
        int x,y;
        instream>>x>>y;
        pol[i][0]=x;
        pol[i][1]=y;
    }
    for(int i=0;i<N;i++){
        int a;
        if(i<N-2)
            a = signedarea(pol[i][0],pol[i][1],pol[i+1][0],pol[i+1][1],pol[i+2][0],pol[i+2][1]);
        else if(i==N-2)
            a = signedarea(pol[N-2][0],pol[N-2][1],pol[N-1][0],pol[N-1][1],pol[0][0],pol[0][1]);
        else if(i==N-1)
            a = signedarea(pol[N-1][0],pol[N-1][1],pol[0][0],pol[0][1],pol[1][0],pol[1][1]);
        if(a==1){
            reverseclock= reverseclock+1;
        }
        else if(a<=0){
            clock=clock+1;
        }
    }
    bool stopping = false;
    for(int i=0;i<N;i++){
        int a;
        int b;
        int vec,vec2;
        if(i!=N-1){
            vec=i;
            vec2=i+1;
        }
        else{
            vec=i;
            vec2=0;
        }
        for(int m=0;m<N;m++){
            a=b=0;
            int vec3,vec4;
            if(m!=N-1){
                vec3=m;
                vec4=m+1;
            }
            else{
                vec3=m;
                vec4=0;
            }
            if(m!=i){
                a=signedarea(pol[vec][0],pol[vec][1],pol[vec2][0],pol[vec2][1],pol[vec3][0],pol[vec3][1])
                *signedarea(pol[vec][0],pol[vec][1],pol[vec2][0],pol[vec2][1],pol[vec4][0],pol[vec4][1]);
                b=signedarea(pol[vec3][0],pol[vec3][1],pol[vec4][0],pol[vec4][1],pol[vec][0],pol[vec][1])
                *signedarea(pol[vec3][0],pol[vec3][1],pol[vec4][0],pol[vec4][1],pol[vec2][0],pol[vec2][1]);
                }
            else{
                continue;
            }
            if(a<0&&b<0){
                stopping = true;
                break;
            }
        }
        if(stopping)
            break;
    }
    if(stopping)
        outstream<<"None"<<endl;
    else{
        if(reverseclock==0||clock==0){
            outstream<<"Convex"<<endl;
        }
        else{
            outstream<<"Concave "<<reverseclock<<endl;
        }
    }
}
