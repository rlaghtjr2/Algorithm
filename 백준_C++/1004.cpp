#include <bits/stdc++.h>
using namespace std;
bool isIn(int x, int y, int circleX, int circleY, int r){
    if( (x-circleX)*(x-circleX) + (y-circleY) * (y-circleY) < r*r ){
        return true;    
    }else{
        return false;
    }
}
int main(){
    int t;
    cin>>t;

    for(int q=0;q<t;q++){
        int start = 0;
        int end = 0;
        int n;
        int x1,y1,x2,y2;
        cin>>x1>>y1>>x2>>y2>>n;
        vector< vector<int> >circle(n,vector<int>(0));
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                int a;
                cin>>a;
                circle[i].push_back(a);
            }
        }

        for(int i=0;i<n;i++){
            if( !(isIn(x1,y1,circle[i][0],circle[i][1],circle[i][2]) && isIn(x2,y2,circle[i][0],circle[i][1],circle[i][2]) ) ){
                if(isIn(x1,y1,circle[i][0],circle[i][1],circle[i][2])){
                    start++;
                }else if(isIn(x2,y2,circle[i][0],circle[i][1],circle[i][2])){
                    end++;
                }

            }
        }

        cout<<start+end<<endl;
    }
}