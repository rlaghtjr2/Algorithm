    #include <bits/stdc++.h>
    using namespace std;

    int main(){
        vector<int> ans;
        int t,x1,x2,y1,y2,r1,r2;
        cin>>t;
        for(int i=0;i<t;i++){
        cin>>x1>>y1>>r1>>x2>>y2>>r2;
            int distance1 = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2); // �߽ɻ��̰Ÿ� ����
            int distance2 = r1 + r2; // ������ ��
            int maxR = max(r1,r2);
            int minR = min(r1,r2);
            if(distance1>(maxR-minR)*(maxR-minR)){ // ��1,��2�� �ٱ��� ������
                if(distance2*distance2 == distance1){
                    ans.push_back(1);
                }else if(distance2*distance2>distance1){
                    ans.push_back(2);
                }else if(distance2*distance2<distance1){
                    ans.push_back(0);
                }
            }else if(distance1<=(maxR-minR)*(maxR-minR)){ //��1 ��2�� �ϳ��� �ٸ����ȿ� �������
                if(distance1==0&&r1==r2){
                    ans.push_back(-1);
                }else if(distance1>0&&distance1==(maxR-minR)*(maxR-minR)){
                    ans.push_back(1);
                }else if(distance1>=0&&distance1<(maxR-minR)*(maxR-minR)){
                    ans.push_back(0);
                }
            }
        }
        for(int i=0;i<ans.size();i++){
            cout<<ans[i]<<endl;
        }
    }
