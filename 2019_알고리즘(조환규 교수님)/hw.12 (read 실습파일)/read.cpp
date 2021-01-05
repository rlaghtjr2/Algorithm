#include <iostream>
#include <fstream>
#include <ostream>
#include <math.h>
#include <vector>
#include <queue>
using namespace std;

int main(){
    ifstream instream("read.inp");
    ofstream outstream("read.out");
    vector<vector<string>> bucket(21);
    vector<vector<string>> bucket2(21);
    queue<string> str;
    int maxlength=0;
    while(!instream.eof()){
        string a;
        instream>>a;
        if(a.length()>maxlength){
            maxlength=a.length();
        }
        switch(a[a.length()-1]){
        case 'a':
            if(a[a.length()-2]=='a'){
                bucket[5].push_back(a);
            }
            else if(a[a.length()-2]=='c'){
                bucket[9].push_back(a);
            }
            else if(a[a.length()-2]=='g'){
                bucket[13].push_back(a);
            }
            else if(a[a.length()-2]=='t'){
                bucket[17].push_back(a);
            }
            break;
        case 'c':
            if(a[a.length()-2]=='a'){
                bucket[6].push_back(a);
            }
            else if(a[a.length()-2]=='c'){
                bucket[10].push_back(a);
            }
            else if(a[a.length()-2]=='g'){
                bucket[14].push_back(a);
            }
            else if(a[a.length()-2]=='t'){
                bucket[18].push_back(a);
            }
            break;
        case 'g':
            if(a[a.length()-2]=='a'){
                bucket[7].push_back(a);
            }
            else if(a[a.length()-2]=='c'){
                bucket[11].push_back(a);
            }
            else if(a[a.length()-2]=='g'){
                bucket[15].push_back(a);
            }
            else if(a[a.length()-2]=='t'){
                bucket[19].push_back(a);
            }
            break;
        case 't':
            if(a[a.length()-2]=='a'){
                bucket[8].push_back(a);
            }
            else if(a[a.length()-2]=='c'){
                bucket[12].push_back(a);
            }
            else if(a[a.length()-2]=='g'){
                bucket[16].push_back(a);
            }
            else if(a[a.length()-2]=='t'){
                bucket[20].push_back(a);
            }
            break;
        }
    }
    for(int i=0;i<21;i++){
        for(int m=0;m<bucket[i].size();m++){
            str.push(bucket[i][m]);
        }
    }
    int cont=maxlength/2;
    int r=2;
    for(int k=0;k<cont;k++){
        int siz = str.size();
        for(int i=1;i<21;i++){
            bucket2[i].clear();
        }
        for(int i=0;i<siz;i++){
            string a = str.front();
            int b = a.length()-1;
            str.pop();
            if(b-r>=0){
                switch(a[b-r]){
                case 'a':
                    if(b-r-1>=0){
                        if(a[b-r-1]=='a'){
                            bucket2[5].push_back(a);
                        }
                        else if(a[b-r-1]=='c'){
                            bucket2[9].push_back(a);
                        }
                        else if(a[b-r-1]=='g'){
                            bucket2[13].push_back(a);
                        }
                        else if(a[b-r-1]=='t'){
                            bucket2[17].push_back(a);
                        }
                    }
                    else{
                        bucket2[1].push_back(a);
                    }
                    break;
                case 'c':
                    if(b-r-1>=0){
                        if(a[b-r-1]=='a'){
                            bucket2[6].push_back(a);
                        }
                        else if(a[b-r-1]=='c'){
                            bucket2[10].push_back(a);
                        }
                        else if(a[b-r-1]=='g'){
                            bucket2[14].push_back(a);
                        }
                        else if(a[b-r-1]=='t'){
                            bucket2[18].push_back(a);
                        }
                    }
                    else{
                        bucket2[2].push_back(a);
                    }
                    break;
                case 'g':
                    if(b-r-1>=0){
                        if(a[b-r-1]=='a'){
                            bucket2[7].push_back(a);
                        }
                        else if(a[b-r-1]=='c'){
                            bucket2[11].push_back(a);
                        }
                        else if(a[b-r-1]=='g'){
                            bucket2[15].push_back(a);
                        }
                        else if(a[b-r-1]=='t'){
                            bucket2[19].push_back(a);
                        }
                    }
                    else{
                        bucket2[3].push_back(a);
                    }
                    break;
                case 't':
                    if(b-r-1>=0){
                        if(a[b-r-1]=='a'){
                            bucket2[8].push_back(a);
                        }
                        else if(a[b-r-1]=='c'){
                            bucket2[12].push_back(a);
                        }
                        else if(a[b-r-1]=='g'){
                            bucket2[16].push_back(a);
                        }
                        else if(a[b-r-1]=='t'){
                            bucket2[20].push_back(a);
                        }
                    }
                    else{
                        bucket2[4].push_back(a);
                    }
                    break;
                }
            }
            else
                bucket2[0].push_back(a);
        }
        r=r+2;
        for(int i=1;i<21;i++){
            for(int m=0;m<bucket2[i].size();m++){
                str.push(bucket2[i][m]);
            }
        }

    }
    int counting =0;
    int maxcounting =0;
    string ans;
    for(int i=0;i<21;i++){
        if(bucket2[i].size()!=0){
            for(int m=0;m<bucket2[i].size()-1;m++){
                if(bucket2[i][m]==bucket2[i][m+1]){
                   counting = counting +1;
                }
                else{
                    counting =0;
                }
                if(counting>maxcounting){
                    maxcounting = counting;
                    ans=bucket2[i][m];
                }
                if(counting==maxcounting){
                    if(ans.compare(bucket2[i][m])==1){
                        ans=bucket2[i][m];
                    }
                }
            }
            counting=0;
        }
        else
            continue;
    }
    outstream<<ans<<endl;
    instream.close();
    outstream.close();
}
