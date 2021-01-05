#include <iostream>
#include <sstream>
#include <bits/stdc++.h>

using namespace std;

void solution(int day, int width, int **blocks) {
  // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
	vector<int> construction(width,0);
	int ans = 0;
	for(int days = 0; days<day; days++){
		int first = 0;
		int second;
		int min = 0;
		
		//벽돌 추가
		for(int i=0;i<width;i++){
			construction[i] = construction[i] + blocks[days][i];
		}	
		
		
		for(int i=1;i<width;i++){
			if(construction[i-1]<construction[i] && construction[i]>construction[i+1] && i!=width-1){
				//마지막이 처음과 마지막이아닐때
				second = i;
				
				if(construction[first]>construction[second]){
					min = construction[second];
				}else{
					min = construction[first];
				}
				
				for(int j=first+1; j<second; j++){
					ans = ans + (min - construction[j]);
					construction[j] = min;
				}
				
				first = i;
				second = 0;
			}else if(i == width -1){
				//마지막일 경우 
				if(construction[i]>construction[i-1]){
					//마지막이 앞에꺼보다 클때
					second = i;
				}else{
					//마지막이 앞에꺼보다 작을때
					second = i-1;
				}
				
				if(construction[first]>construction[second]){
					min = construction[second];
				}else{
					min = construction[first];
				}
				
				for(int j=first+1; j<second; j++){
					ans = ans + (min - construction[j]);
					construction[j] = min;
				}
				
			}
		}
	}
	cout<<ans<<endl;
}

struct input_data {
  int day;
  int width;
  int **blocks;
};

void process_stdin(struct input_data& inputData) {
  string line;
  istringstream iss;

  getline(cin, line);
  iss.str(line);
  iss >> inputData.day;

  getline(cin, line);
  iss.clear();
  iss.str(line);
  iss >> inputData.width;

  inputData.blocks = new int*[inputData.day];
  for (int i = 0; i < inputData.day; i++) {
    getline(cin, line);
    iss.clear();
    iss.str(line);
    inputData.blocks[i] = new int[inputData.width];
    for (int j = 0; j < inputData.width; j++) {
      iss >> inputData.blocks[i][j];
    }
  }
}

int main() {
	struct input_data inputData;
	process_stdin(inputData);

	solution(inputData.day, inputData.width, inputData.blocks);
	return 0;
}