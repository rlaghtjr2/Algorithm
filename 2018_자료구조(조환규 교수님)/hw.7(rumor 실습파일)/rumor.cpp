#include <bits/stdc++.h>
using namespace std;
int N,x,d,i,m,stu,siz,star,s;
int main(){
    ifstream instream("rumor.inp");
    ofstream outstream("rumor.out");
    instream>>N>>x>>d;
    vector<vector<int>> v (2,vector<int>(N+1,0)); //들어갓다는걸 확인하기 위한 v생성
    vector<vector<int>> v2 (N,vector<int>(0,0));//전체 v2생성.
    for(i=1;i<N+1;i++){
        v[0][i]=i;
    } //v[0]에 0부터 N까지 번호를 줌.
    for(i=0;i<N;i++){
        int stu=1; //stu에 값을 안주면 멈춰버림.
        while(stu!=0){
            instream>>stu;
            if(stu!=0){
                v2[i].push_back(stu);
            }
            else
                continue;
        }
    } //v2만들기.
    for(i=0;i<N;i++){
        sort(v2[i].begin()+1,v2[i].end());
    } //낮은번호부터 들어가니 정렬을 해야 하 므로 정렬함.
    sort(v2.begin(),v2.end());// 앞에 번호도 차례로 함.
    queue<int> q; //q생성
    q.push(x);  //처음에 시작하는 값을 넣음.
    v[1][x]=1; //x가 들어갓으므로 v[1][x]에 1로 바꿈.
    if(v2[x-1].size()==1){
        outstream<<x<<endl;
    } //예제데이터2번같이, 만약 사이즈가 1 (친구없을떄) x만출력하고 끝냄.
    else{ //친구없는 경우를 제외한,
        for(s=0;s<d+1;s++){ //마지막에 outstream하므로,d+1일까지 해야함.
            siz=q.size(); //몇번 돌릴건지 처음 q.size()만큼 돌려야 위에 s쓴 for문이 한바퀴돔.
            for(m=0;m<siz;m++){ // 처음들어가잇는 size만큼 함.
                star=q.front(); //star에 작업돌릴꺼 저장
                for(i=1;i<v2[star-1].size();i++){ //star에 있는것들 대입하는데, 이미 있떤거면 안하고 없는거면 하고 v에 1로 표시해서 한거라고 표시함.
                    if(v[1][v2[star-1][i]]==0){
                        q.push(v2[star-1][i]);
                        v[1][v2[star-1][i]]=1;
                    }
                    else
                        continue; // 1일경우는 있으므로 continue해서 패스.
                }
                outstream << q.front()<<endl; // 다햇으면 출력 후 pop해서 다음껄로 진행.
                q.pop();
            }
        }
    }
    instream.close();
    outstream.close();
}
