#include <bits/stdc++.h>

using namespace std;

vector<int> mergeSort(vector<int> &num,int start, int end){
    if(start==end){
        vector<int> a(1,num[start]);
        return a;
    }
    vector<int> first = mergeSort(num,start,(start+end)/2);
    vector<int> second = mergeSort(num,((start+end)/2)+1,end);
    vector<int> final;
    int fCount = 0;
    int sCount = 0;

    for(int i=0;i<first.size()+second.size();i++){
        if(fCount>=first.size()){
            final.push_back(second[sCount]);
            sCount++;
        }else if(sCount>=second.size()){
            final.push_back(first[fCount]);
            fCount++;
        }else{
            if(first[fCount]>second[sCount]){
                final.push_back(second[sCount]);
                sCount++;
            }else{
                final.push_back(first[fCount]);
                fCount++;
            }
        }
    }

    return final;
}
int main(){
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    int n;
    cin>>n;

    vector<int> num(n);

    for(int i=0;i<n;i++){
        cin>>num[i];
    }

    num = mergeSort(num,0,n-1);

    for(int i=0;i<num.size();i++){
        cout<<num[i]<<"\n";
    }
}