#include <bits/stdc++.h>
using namespace std;

int main(){
    int n,m;
    int ans=0;
    cin>>n;
    vector<int> crane(n);
    for(int i=0;i<n;i++){
        cin>>crane[i];
    }

    cin>>m;
    vector<int> box(m);
    for(int i=0;i<m;i++){
        cin>>box[i];    
    }
    sort(box.begin(),box.end());

    while(!box.empty()){
        ans++;
        int counting = 0;
        for(int i=0;i<n;i++){
            if(crane[i]<box.front()){
                counting++;
            }else{
                for(int j=box.size()-1;j>=0;j--){
                    if(crane[i]>=box[j]){
                        box.erase(box.begin()+j);
                        break;
                    }
                }
            }
            if(counting == n){
                ans = -1;
                break;
            }
        }
        if(ans == -1){
            break;
        }
    }
    cout<<ans<<endl;
}