#include <bits/stdc++.h>
using namespace std;
int N;
int counting;
string word;
int main(){
    ifstream instream("palin.inp");
    ofstream outstream("palin.out");
    instream>>N;
    for(int i=0;i<N;i++){
        instream>>word;
        counting=0;
        int number1 = 0;
        int number2 = word.length()-1;
            for(int a=0;a<(word.length()/2);a++){
                if(word[number1]==word[number2]){
                    number1++;
                    number2--;
                }
                else{
                    if(word[number1]==word[number2-1]&&counting!=2){
                        number1++;
                        number2=number2-2;
                        counting++;
                    }
                    else if(word[number1+1]==word[number2]&&counting!=2){
                        number1=number1+2;
                        number2--;
                        counting++;
                    }
                    else if(word[number1+1]!=word[number2]){
                        counting=2;
                        break;
                    }
                    else if(word[number1]!=word[number2-1]){
                        counting=2;
                        break;
                    }
                }
            }
            if(counting==0){
                outstream<<"1"<<endl;
            }
            else if(counting==1){
                outstream<<"2"<<endl;
            }
            else if(counting==2){
                outstream<<"3"<<endl;
            }
    }
    instream.close();
    outstream.close();
}
