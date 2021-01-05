#include <iostream>
#include <fstream>
using namespace std;
int i,counting,num=1,n1,m1,s1,s2;
int **nano;
int main(){
	ifstream nanobot("nanobot.inp");

	int n, m, x, y, k;
	nanobot >> n >> m >> x >> y >> k;
	nanobot.close();
	ofstream outstream;
	outstream.open("nanobot.out");
	int c=m,d=-1;//초기값설정.
	nano = new int*[m];
	for (i = 0; i < m; i++){
	    nano[i] = new int[n];
	}//2차배열 동적할당.
	int row=m;
	int col=n;

	for(counting=0;counting<col*row;m=m-2,n=n-2){//n과m은 횟수.
        for(n1=m;n1>0;c--,n1--){
            if(num==k){
                s1=c-1;
                s2=d+1;
            }
            nano[c-1][d+1]=num;
            num++;
            counting++;

        }//n1=5, n=5, m=8, c=-1 d=-1
        d=d+1;//c=0, d=0
        for(m1=n-1;m1>0;d++,m1--){
            if(num==k){
                s1=c;
                s2=d+1;
            }
            nano[c][d+1]=num;
            num++;
            counting++;
        }
        // n=5, m=8 c=0, d=7
        for(n1=m-1;n1>0;c++,n1--){
            if(num==k){
                s1=c+1;
                s2=d;
            }
            nano[c+1][d]=num;
            num++;
            counting++;
        }
        d=d-1;//n=5, m=8, c=5 d=7
        for(m1=n-2;m1>0;d--,m1--){
            if(num==k){
                s1=c;
                s2=d;
            }
            nano[c][d]=num;
            num++;
            counting++;
        }
	}

    outstream<<nano[row-y][x-1]<<endl;
    outstream<<s2+1<<" "<<row-s1<<endl;
	outstream.close();
	return 0;
}
