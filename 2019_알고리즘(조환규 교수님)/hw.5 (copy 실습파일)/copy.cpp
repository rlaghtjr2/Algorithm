#include <bits/stdc++.h>
using namespace std;
int N;
vector<float> chk;
int maxi(int a, int b){
     int max=0;
     if(a>max){
         max=a;
     }
     if(b>max){
         max=b;
     }
     return max;
}
int main(){
    std::ios::sync_with_stdio(false);
    std::locale loc("en_US.UTF-8");
    std::wcout.imbue(loc); // Use it for output

    std::wfstream file("copy.inp");
    file.imbue(loc); // Use it for file input

    std::wofstream out("copy.out");
    out.imbue(loc); // Use it for file input
    file>>N;
    vector<vector<wstring>> str(N,vector<wstring>(0,L"0"));

    for(int m=0;m<N;m++){
        while(true){
            wstring a;
	    getline(file,a);
            for(int i=0;i<a.length();i++){
		wstring b;
		b=a[i];
		wstring c;
                if(b==L"은"){
                    str[m].push_back(L"는");
                }
                else if(b==L"을"){
                    str[m].push_back(L"를");
                }
		else if(b==L" "){
			c=a[i+1];
			if(c!=L" "){
				str[m].push_back(L" ");
			}
		}
		else if(b==L"$"){
			break;
		}
                else{
                    str[m].push_back(b);
                }
            }
	wstring c;
	c=a[a.length()-1];
        if(c==L"$"){
            break;
            }
        }
    }
    for(int t=1;t<N;t++){
   	 vector<vector<int>> str1(str[t].size()+1,vector<int>(str[0].size()+1,0));
    	for(int col=1; col<str[t].size()+1;col++){
		for(int row=1;row<str[0].size()+1;row++){
			if(str[0][row-1]==str[t][col-1]){
				str1[col][row]=str1[col-1][row-1]+1;
			}
			else{
				str1[col][row]=maxi(str1[col-1][row],str1[col][row-1]);
			}
		}
	}
	chk.push_back(str1[str[t].size()][str[0].size()]*1000*2/(str[0].size()+str[t].size()));
    }
    int maxim=0;
    int maxnum;
    for(int i=0;i<chk.size();i++){
	if(chk[i]>maxim){
		maxim=chk[i];
		maxnum=i;
	}
    }
    out<<maxnum+2<<endl;
    out.flush();
}
