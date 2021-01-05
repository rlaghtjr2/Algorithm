#include <bits/stdc++.h>
using namespace std;
int K,counting,startnumber,endnumber,i;
double N;
string work;
int main(){
    ifstream instream ("card.inp");
    ofstream outstream ("card.out");
    instream>>N>>K;
    list<int>card,carda,cardb;
    list<int>::iterator it;
    list<int>::iterator ita;
    list<int>::iterator itb;
    list<int>::iterator startaddress;
    for(i=0;i<N;i++){
        card.push_back(i+1);
    }
    counting=0;
    while(counting<K){
        instream>>work;
        if(work=="Shuffle"){
            it=card.begin();
            for(i=0;i<ceil(N/2);i++){
                carda.push_back(*it);
                it++;
            }
            for(i=0;i<(N/2);i++){
                cardb.push_back(*it);
                it++;
            }
            card.clear();
            ita=carda.begin();
            itb=cardb.begin();
            for(i=0;i<N/2;i++){
                card.push_back(*ita);
                card.push_back(*itb);
                ita++;
                itb++;
            }
            if((int)N%2==1){
                card.pop_back();
            }
            carda.clear();
            cardb.clear();
        }
        else if(work=="Cut"){
            instream>>startnumber>>endnumber;
            it=card.begin();
            for(i=0;i<endnumber;i++){
                if(i>=startnumber-1){
                    if(i==startnumber-1){
                        startaddress=it;
                    }
                    card.push_back(*it);
                }
                ++it;
            }
            card.erase(startaddress,it);
        }
        counting++;
    }
    outstream<<card.front()<<" ";
    it=card.begin();
    for(i=0;i<N;i++){
        if(i==floor((N/2))-1){
            outstream<<*it<<" ";
        }
        ++it;
    }
    outstream<<card.back();
    instream.close();
    outstream.close();
}
