#include <iostream>
#include <fstream>
int N,K,n,m,i,tim,sool;
int nu;
int **log;
int **tap;
int a,b,c,d,number;
using namespace std;
int main(){
	ifstream text("syslog.txt");//txt파일 열기
	//int N,K,r,n,m,i,time,sool;
	//int nu;
	//int **log;
	text >> N;
	log = new int*[N];
	for (i = 0; i < N; i++)
	    log[i] = new int[1000]{0}; //log[n][10000]생성.
    //int **tap;
    tap = new int*[N];
    for (i = 0; i < N; i++)
	    tap[i] = new int[1]{0};
	for(i=0;i<N;i++){
       for(m=0;;m++){
            text>>tim;
            if(tim==0){
                sool=m-1;
                tap[i][0]=sool;
                break;}
            log[i][m]=tim;
       }
        //cout<<tap[i][0]<<endl;
    }
    tap[0][1]=tap[0][0];
    for(i=1;i<N;i++){
        tap[i][1]=tap[i-1][1]+tap[i][0];
        //cout<<tap[i][1]<<endl;
    }
	text.close();//txt파일 닫기
    ifstream in("log.inp");//in파일 열기
    int **input;
    in >> K;
    input = new int*[K];
	for (i = 0; i < K; i++)
	    input[i] = new int[3]; //in파일 2차배열로 생성.
    for(i=0;i<K;i++){
       for(m=0;m<4;m++){
            in>>tim;
            input[i][m]=tim;
       }
    }
    in.close();
    //int a,b,c,d,e,f,g,h,number;
    ofstream outstream;//출력파일 생성
    outstream.open("log.out");
    for(i=0;i<K;i++){
        int number=0;
        if ((input[i][2]<log[0][0])||(input[i][2]==log[0][0]&&input[i][3]<log[0][1])){
            outstream<<0<<'\n';
            continue;
        }
        for(m=0;m<N;m++){
            if(input[i][0]<log[m][0]){
                a=m; //a는 처음 출발할때의 주소 입력.
                if(log[m][0]>input[i][2]){
                    a=b=c=d=0;
                    break;
                }
                c=1;//c는 처음출발할때의 값
                break;} //
            else if(input[i][0]==log[m][0]){
                a=m;
                for(n=1;n<1000;n++){
                    if(input[i][1]<=log[m][n]){
                        c=n;
                        break;
                        }
                    else
                        c=999;

                    }
                break;
            }

        }
        for(m=0;m<N;m++){
            if(input[i][2]<log[m][0]){
                b=m-1;//b는 끝지점의 주소.
                d=999;
                if(input[i][0]>log[b][0]){
                    a=b=c=d=0;}
                break;
                }//d는 마지막지점의 값.
            else if(input[i][2]==log[m][0]){
                if(input[i][3]<log[m][1]){
                    b=m-1;
                    d=999;
                    break;
                }
                else if(input[i][3]>=log[m][1]){
                    for(n=1;n<1000;n++){
                        if(input[i][3]<log[m][n]){
                            b=m;
                            d=n-1;
                            break;
                        }
                        else if(input[i][3]==log[m][n]){
                            b=m;
                            d=n;
                            break;
                        }
                        else{
                            b=m;
                            d=999;

                    }

                    }
                break;
                }

                break;
            }
            else if(input[i][2]>log[N-1][0]){
                b=N-1;
                d=999;
                break;
            }
        }
    if(input[i][0]>log[N-1][0]){
            a=b=c=d=0;}
    if(input[i][0]<log[0][0]&&input[i][2]<log[0][0]){
        a=b=c=d=0;
    }

    if(c==0&&d==0&&a==0&&b==0){
        number=0;
    }
    else if(a==b){
        for(n=c;n<d+1;n++){
            if(log[a][n]!=0)
                number=number+1;
        }
    }

    else  {
            for(n=c;n<1000;n++){

                if(log[a][n]!=0)
                    number=number+1;
                else
                    break;
            }
            for(n=1;n<d+1;n++){
                if(log[b][n]!=0)
                    number=number+1;
                else
                    break;
            }
            number=number+tap[b-1][1]-tap[a][1];
   }
        //cout<<number<<endl;
        outstream<<number<<"\n";

    }





    outstream.close();//출력파일 닫기
}


