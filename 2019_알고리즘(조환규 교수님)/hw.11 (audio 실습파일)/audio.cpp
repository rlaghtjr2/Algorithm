#include <bits/stdc++.h>
using namespace std;
int N;
int mindis;
int audiodis3(vector<int> &ans, vector<vector<int>> &audio){
    int dis = 0;
    for(int i=0;i<N;i++){
        for(int m=i+1;m<N;m++){
            if(audio[ans[i]-1][ans[m]]!=0){
                dis = dis + (m-i);
            }
            if(dis>mindis)
                break;
        }
        if(dis>mindis)
            break;
    }
    return dis;
}
int main(){
    ifstream instream("audio.inp");
    ofstream outstream("audio.out");
    instream>>N;
    vector<vector<int>> audio2(N, vector<int> (N+1,0));
    vector<int> ans(N,0);
    vector<int> ans2;
    for(int i=0;i<N;i++){
        int a;
        instream>>a;
        audio2[i][0]=a;
        while(true){
            int a;
            instream>>a;
            if(a==0)
                break;
            else
                audio2[i][a]=a;
        }
    }
    vector<int> v;
	for(int i=0; i<N ;i++){
		v.push_back(i+1);
	}
	mindis = 300;
	do{
		int diss = audiodis3(v,audio2);
		if(diss<mindis){
            mindis=diss;
            ans2=v;
		}
	}while(next_permutation(v.begin(), v.end()));
	outstream<<mindis<<endl;
    for(int i=0;i<N;i++){
        outstream<<ans2[i]<<" ";
    }
	return 0;
}
