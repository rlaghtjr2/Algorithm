#include <bits/stdc++.h>
#include "oil.h"
using namespace std;
int oilsize,oilstart,oilend,callnum,calllimit;
int i, j,a;
int checkoil_first(int firststart, int firstend, int secondstart, int secondend, int *i){
    int a = observe(firststart,firstend);
    if(a == 1){
        *i = firststart;
        return firststart;
    }
    else if (a == 2){
        if(firstend-firststart==1){
            int c = observe(firststart,firststart);
            if(c==1){
                *i=firststart;
                return firststart;
            }
            else{
                *i=firstend;
                return firstend;
            }
        }
        secondend = firstend;
        firstend = (firststart+firstend)/2;
        secondstart = firstend + 1;
        checkoil_first(firststart,firstend,secondstart,secondend,i);
    }
    else if(a == 0){
            firststart = secondstart;
            firstend = (secondstart+secondend)/2;
            secondstart = firstend+1;
            checkoil_first(firststart,firstend,secondstart,secondend,i);
    }
}
int checkoil_second(int firststart, int firstend, int secondstart, int secondend, int *j){
    int b = observe(secondstart,secondend);
    if( b== 1){
        *j = secondend;
        return secondend;
    }
    else if (b == 2){
        firststart = secondstart;
        firstend = (secondstart+secondend)/2;
        secondstart = firstend + 1;
        checkoil_second(firststart,firstend,secondstart,secondend,j);
    }
    else if ( b==0){
        if(firststart == firstend &&secondstart == secondend){
            int c = observe(secondstart,secondend);
            if (c == 1){
                *j = secondstart;
                return secondstart;
            }
            else{
                *j = firstend;
                return firstend;
            }
        }
        secondend=firstend;
        firstend=(firststart+firstend)/2;
        secondstart=firstend+1;
        checkoil_second(firststart,firstend,secondstart,secondend,j);
    }
}
int main(){
    initial();
    oilsize = oil_size( );
    int firststart = 0;
    int firstend = oilsize/2;
    int secondstart = firstend+1;
    int secondend = oilsize-1;
    checkoil_first(firststart,firstend,secondstart,secondend,&i);
    int c = observe(i+1,i+2);
    if(c==2){
        j=i+1;
    }
    else if(c==0){
        j=i;
    }
    else if(c==1){
        firststart = i;
        firstend = (firststart + secondend)/2;
        secondstart = firstend+1;
        checkoil_second(firststart,firstend,secondstart,secondend,&j);
    }
    oil_report(i,j);

}
