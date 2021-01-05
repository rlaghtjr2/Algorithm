#include <bits/stdc++.h>

using namespace std;

int main(){
    int n;
    int count = 0;
    cin>>n;

    vector<int> num(n);

    for(int i=0;i<n;i++){
        cin>>num[i];
    }

    for(int i=0;i<n;i++){
        int min = num[i];
        int minCount = i;
        for(int j=i+1;j<n;j++){
            if(min>num[j]){
                min = num[j];
                minCount = j;
            }
        }
        int tmp = num[count];
        num[count] = num[minCount];
        num[minCount] = tmp;

        count++;
    }

    for(int i=0;i<n;i++){
        cout<<num[i]<<endl;
    }
}