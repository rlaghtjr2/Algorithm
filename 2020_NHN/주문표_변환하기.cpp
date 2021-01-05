#include <iostream>
#include <sstream>
#include <bits/stdc++.h>

using namespace std;

void solution(int numOfOrder, string *orderArr) {
  // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
	for(int counting = 0; counting<numOfOrder; counting++){
		string ans= "";
		
		string str = orderArr[counting];
		string cmpStr = "";
		
		stack<int> startStack;
		stack<char> frontBrack;
		
		//문자에서 괄호빼고 처리.
		for(int i=0;i<str.length()-1;i++){
			if(str[i]>=48 && str[i]<=57 && str[i+1]>=65 && str[i+1]<=90){
				for(int j=0;j<str[i]-48;j++){
					cmpStr= cmpStr+str[i+1];	
				}
				i=i+1;
			}else{
				cmpStr=cmpStr+str[i];
				if(i == str.length()-2){
					cmpStr = cmpStr + str[str.length()-1];
				}
			}
		}
		
		str = cmpStr;
		startStack.push(0);
		
		//괄호 처리
		for(int i=1;i<str.length();i++){
			if(str[i] == '('){
				startStack.push(i);
				frontBrack.push(str[i-1]);
			}else if(str[i] == ')'){
				char front = frontBrack.top();
				int start = startStack.top();
				
				startStack.pop();
				frontBrack.pop();
				
				//처음일경우 ans가 ""이니 괄호안에꺼를 ans에 넣어줌.
				if(ans== ""){
					for(int j = start+1;j<i;j++){
						ans = ans+str[j];
					}
				}
				
				//괄호 ( 앞이 숫자일 경우
				if(front>=48 && front<=57){
					string cmp = ans;
					for(int j=0;j<front-49;j++){
						ans = ans + cmp;
					}	
				}else{ // 괄호 ( 앞이 문자일 경우
					string cmp="";
					for(int j=0;j<ans.length();j++){
						cmp = cmp+front+ans[j];
					}
					ans = cmp;
				}
				
				//괄호처리하고 앞에 괄호가아니라 문자가 더 있을경우 붙여줌
				for(int j = start-2;j>=startStack.top();j--){
					if(str[j] != '(' && str[j] != ')'){
						ans = str[j]+ans;
					}
				}
				
			}
		}
		
		if(ans==""){
			//다끝나고 ans가 ""일경우 == 괄호 없을경우 str이 답임.
			ans = str;
		}
		
		cout<<ans<<endl;
	}
}

struct input_data {
  int numOfOrder;
  string *orderArr;
};

void process_stdin(struct input_data& inputData) {
  string line;
  istringstream iss;

  getline(cin, line);
  iss.str(line);
  iss >> inputData.numOfOrder;

  inputData.orderArr = new string[inputData.numOfOrder];
  for (int i = 0; i < inputData.numOfOrder; i++) {
    getline(cin, line);
    iss.clear();
    iss.str(line);
    iss >> inputData.orderArr[i];
  }
}

int main() {
  struct input_data inputData;
  process_stdin(inputData);

  solution(inputData.numOfOrder, inputData.orderArr);
  return 0;
}