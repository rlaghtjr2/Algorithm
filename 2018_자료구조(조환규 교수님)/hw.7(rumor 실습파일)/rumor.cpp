#include <bits/stdc++.h>
using namespace std;
int N,x,d,i,m,stu,siz,star,s;
int main(){
    ifstream instream("rumor.inp");
    ofstream outstream("rumor.out");
    instream>>N>>x>>d;
    vector<vector<int>> v (2,vector<int>(N+1,0)); //���ٴ°� Ȯ���ϱ� ���� v����
    vector<vector<int>> v2 (N,vector<int>(0,0));//��ü v2����.
    for(i=1;i<N+1;i++){
        v[0][i]=i;
    } //v[0]�� 0���� N���� ��ȣ�� ��.
    for(i=0;i<N;i++){
        int stu=1; //stu�� ���� ���ָ� �������.
        while(stu!=0){
            instream>>stu;
            if(stu!=0){
                v2[i].push_back(stu);
            }
            else
                continue;
        }
    } //v2�����.
    for(i=0;i<N;i++){
        sort(v2[i].begin()+1,v2[i].end());
    } //������ȣ���� ���� ������ �ؾ� �� �Ƿ� ������.
    sort(v2.begin(),v2.end());// �տ� ��ȣ�� ���ʷ� ��.
    queue<int> q; //q����
    q.push(x);  //ó���� �����ϴ� ���� ����.
    v[1][x]=1; //x�� �����Ƿ� v[1][x]�� 1�� �ٲ�.
    if(v2[x-1].size()==1){
        outstream<<x<<endl;
    } //����������2������, ���� ����� 1 (ģ��������) x������ϰ� ����.
    else{ //ģ������ ��츦 ������,
        for(s=0;s<d+1;s++){ //�������� outstream�ϹǷ�,d+1�ϱ��� �ؾ���.
            siz=q.size(); //��� �������� ó�� q.size()��ŭ ������ ���� s�� for���� �ѹ�����.
            for(m=0;m<siz;m++){ // ó�����մ� size��ŭ ��.
                star=q.front(); //star�� �۾������� ����
                for(i=1;i<v2[star-1].size();i++){ //star�� �ִ°͵� �����ϴµ�, �̹� �ֶ��Ÿ� ���ϰ� ���°Ÿ� �ϰ� v�� 1�� ǥ���ؼ� �ѰŶ�� ǥ����.
                    if(v[1][v2[star-1][i]]==0){
                        q.push(v2[star-1][i]);
                        v[1][v2[star-1][i]]=1;
                    }
                    else
                        continue; // 1�ϰ��� �����Ƿ� continue�ؼ� �н�.
                }
                outstream << q.front()<<endl; // �������� ��� �� pop�ؼ� �������� ����.
                q.pop();
            }
        }
    }
    instream.close();
    outstream.close();
}
