
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
using namespace std;
int K,N,M,carnumber,i,j,p;
int carsum=0;
int *number;

void add(vector<int> &A,int B[],int *c,int *m){
    vector<int>::iterator it;
    it=find(A.begin(),A.end(),0);
    if(*B>0&&it!=A.end()){
        /*=if(A.size()==*m){
            *m=(*m)*2;
            A.resize(*m,0);
        }*/
        it=find(A.begin(),A.end(),0);
        A.erase(it);
        A.insert(it,*B);
        *c=(*c)+1;
        it=find(A.begin(),A.end(),0);
        if(it==A.end())
            *m=(*m)*2;
            A.resize(*m,0);
    }
    if(*B<0){
        it=find(A.begin(),A.end(),-(*B));
        A.erase(it);
        A.insert(it,0);
        *c=(*c)-1;
    }

    /*else if(*B>0&&it==A.end()){
        *m=(*m)*2;
        A.resize(*m,0);
        it=find(A.begin(),A.end(),0);
        A.erase(it);
        A.insert(it,*B);
        *c=(*c)+1;
    }*/

}     //car number�� �߰��ϴ°�+�� �� ���� ����. add(slot,number+i,&carsum) ���� �����ϸ��.

/*void expand(vector<int> &A,int *m){
    vector<int>::iterator it;
    it=find(A.begin(),A.end(),0);
    if(it==A.end())
        *m=(*m)*2;
        A.resize(*m,0);
}*/ // slot�� ��ã���� ������ �Լ�, main�Լ����� �����Ҷ� expand(slot,&K) �ϸ��.
void reduce(vector<int> &A,int *m,int n,int j){
    int e=0;
    vector<int> B(*m,0);
    vector<int>::iterator it;
    if(*m>j){
        if(((*m)/3)>=n){
            for(p=0;p<*m;p++){
                if(A[p]!=0){
                    B[e]=A[p];
                    e++;
                }
            }

            *m=(*m)/2;
            A=B;
            A.resize(*m);
            if(*m<j){
                for(p=0;p<*m;p++){
                    if(A[p]!=0){
                        B[e]=A[p];
                        e++;
                }
            }
                 A=B;
                *m=j;
            }
        }

    }

} // slot�� �پ�鶧 �ϴ� �Լ�, main�Լ����� �����Ҷ� reduce(slot,&K,carsum,M)�ϸ��.
int main(){
    ifstream instream("3.inp"); //in���� �ҷ�����
    instream >> K >> N;
    number = new int[N-1];
    for(i=0;i<N;i++){
        instream >> carnumber;
        number[i]= carnumber;
    }
    instream.close();//in���� �ݱ�
    ofstream outstream;//������� ����
    outstream.open("parking.out");
    vector<int> slot(K);
    vector<int>::iterator it;
    M=K;
    for(i=0;i<N;i++){
        //expand(slot,&K);
        //reduce(slot,&K,carsum,M);
        add(slot,number+i,&carsum,&K);
        reduce(slot,&K,carsum,M);
        //vector<int> slot(K);
        }
    cout<<slot.size()<<endl;
       /* it=find(slot.begin(),slot.end(),0);
        if(it==slot.end()){
            expand(slot,&K);
        }
        else if(((K)/3)>=carsum){
            reduce(slot,&K,carsum);
        }
    }
    for(i=K;i<N;i++){
        it=find(slot.begin(),slot.end(),0);
        if(it==slot.end()){
            expand(slot,&K);
        }
        else if(((K)/3)>=carsum){
            reduce(slot,&K,carsum,M);
        }
        add(slot,number+i,&carsum);
    }
    if(it==slot.end()){
            expand(slot,&K);
        }
        else if(((K)/3)>=carsum){
            reduce(slot,&K,carsum,M);
        }*/
    for(i=0;i<K;i++){
        if(slot[i]!=0)
            outstream<<i+1<<" "<< slot[i]<<endl;
    }
    outstream.close();//������� �ݱ�
}
