#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    int counting = 9;
    cin>>n;
    int ans = 0;

    int q = -1;
    int w = -1;
    vector<int> a(9,1);
    vector<int> b(9,1);
    if(n<=9){
        cout<<n<<endl;
    }else if(n<=1022){
        for(int count = 0;count<9;count++){
            b=a;
            a.clear();
            for(int i=0;i<9;i++){
                if(i<count){
                    a.push_back(0);
                }else{
                    if(i==0){
                        a.push_back(1);
                        counting=counting+1;
                        if(n<=counting){
                            counting=counting-1;
                            q = count+1;
                            w = i+1;
                            break;
                        }
                    }else{
                        a.push_back(a[i-1]+b[i-1]);
                        counting=counting+a[i-1]+b[i-1];
                        if(n<=counting){
                            counting=counting-a[i-1]-b[i-1];
                            q = count+1;
                            w = i+1;
                            break;
                        }
                    }
                }
            }
            if(q!=-1){
                break;
            }
        }  
        // cout<<counting<<endl;
        for(long long i=pow(10,q)*w;i<pow(10,q)*(w+1);i++){
            long long r = i;
            long long num = pow(10,q);
            long long one;
            long long two;
            while(true){
                // cout<<r<<endl;
                one = r/num;
                two = (r%num)/(num/10);
                if(two>=one){
                    i=i+num;
                    i=i-(i%num)-1;
                    break;
                }
                if(r<100){
                    counting++;
                    // cout<<"counting ! : "<<counting<<endl;
                    break;
                }
                r=r%num;
                num=num/10;
            }

            if(counting==n){
                cout<<i<<endl;
                break;
            }
        }
    }else{
        cout<<-1<<endl;
    }

}