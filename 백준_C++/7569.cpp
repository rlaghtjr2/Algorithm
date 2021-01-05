#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,m,h;
    int result = -1;
    cin>>m>>n>>h;

    vector< vector< vector<int> > > tomato(h, vector< vector<int> >(n, vector<int>(m,0)));
    queue<int> bfsH;
    queue<int> bfsN;
    queue<int> bfsM;

    for(int i=0;i<h;i++){
        for(int j=0;j<n;j++){
            for(int k=0;k<m;k++){
                int a;
                cin>>a;
                tomato[i][j][k] = a;
                if(a == 1){
                    bfsH.push(i);
                    bfsN.push(j);
                    bfsM.push(k);
                }
            }
        }
    }

    while(!bfsH.empty()){
        int queSize = bfsH.size();
        result++;
        for(int i=0; i<queSize; i++){
            int elementH = bfsH.front();
            int elementN = bfsN.front();
            int elementM = bfsM.front();

            bfsH.pop();
            bfsN.pop();
            bfsM.pop();

            if(elementH != h-1){
                if(tomato[elementH+1][elementN][elementM] == 0){
                    bfsH.push(elementH+1);
                    bfsN.push(elementN);
                    bfsM.push(elementM);
                    
                    tomato[elementH+1][elementN][elementM] = 1;
                }
            }

            if(elementH != 0){
                if(tomato[elementH-1][elementN][elementM] == 0){
                    bfsH.push(elementH-1);
                    bfsN.push(elementN);
                    bfsM.push(elementM);

                    tomato[elementH-1][elementN][elementM] = 1;
                }
            }

            if(elementN != n-1){
                if(tomato[elementH][elementN+1][elementM] == 0){
                    bfsH.push(elementH);
                    bfsN.push(elementN+1);
                    bfsM.push(elementM);

                    tomato[elementH][elementN+1][elementM] = 1;
                }
            }

            if(elementN != 0){
                if(tomato[elementH][elementN-1][elementM] == 0){
                    bfsH.push(elementH);
                    bfsN.push(elementN-1);
                    bfsM.push(elementM);

                    tomato[elementH][elementN-1][elementM] = 1;
                }
            }

            if(elementM != m-1){
                if(tomato[elementH][elementN][elementM+1] == 0){
                    bfsH.push(elementH);
                    bfsN.push(elementN);
                    bfsM.push(elementM+1);

                    tomato[elementH][elementN][elementM+1] = 1;
                }
            }

            if(elementM != 0){
                if(tomato[elementH][elementN][elementM-1] == 0){
                    bfsH.push(elementH);
                    bfsN.push(elementN);
                    bfsM.push(elementM-1);

                    tomato[elementH][elementN][elementM-1] = 1;
                }
            }
        }
    }

     for(int i=0;i<h;i++){
        for(int j=0;j<n;j++){
            for(int k=0;k<m;k++){
                if(tomato[i][j][k] == 0){
                    result = -1;
                    break;
                }
            }
            if(result == -1){
                break;
            }
        }
        if(result == -1){
            break;
        }
    }

    cout<<result<<endl;
}