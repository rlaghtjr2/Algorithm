#include <iostream>
#include <sstream>
#include <bits/stdc++.h>

using namespace std;

void solution(int numOfAllPlayers, int numOfQuickPlayers, char *namesOfQuickPlayers, int numOfGames, int *numOfMovesPerGame) {
  // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
	int start = 0;
	char tagger = 'A';
	vector<char> players(numOfAllPlayers-1,' ');
	vector<char> quickPlayers(numOfQuickPlayers,' ');
	vector<int> numPlayer(numOfAllPlayers,0);
	
	numPlayer[0] = 1;
	
	//Plyaer 추가
	for(int i=0;i<numOfAllPlayers-1;i++){
		players[i] = 'B'+i;
	}
	
	//QuickPlayer추가
	for(int i=0;i<numOfQuickPlayers;i++){
		quickPlayers[i] = namesOfQuickPlayers[i];
	}
	
	for(int i=0;i<numOfGames;i++){
		int moving = numOfMovesPerGame[i];
		
		start = start + moving;
		if(start<0){
				//start가 0보다 작을경우 -> 반대방향으로 돈거임 
				while(true){
					// 배열범위 안에 들어갈수잇도록 players.size()만큼 더해줌 -> plaeyrs.size()=한바퀴
					start = start + players.size();
					if(start>=0 && start<players.size()){
						break;
					}
			}
		}else if(start>=players.size()){
			//start가 players.size()배열보다 크거나 같은경우 -> 한바퀴 이상 돈거
			while(true){
				// 배열범위 안에 들어갈수잇도록 players.size()만큼 빼줌 -> plaeyrs.size()=한바퀴
				start = start - players.size();
				if(start>=0 && start<players.size()){
						break;
					}
			}
		}
		
		for(int j=0;j<quickPlayers.size();j++){
			if(players[start] == quickPlayers[j]){
				//빠른사람일 경우 술래의 횟수 추가
				numPlayer[ tagger-'A' ]++;
				break;
			}
			
			if(j==quickPlayers.size()-1){
				//빠른사람이 아닐 경우 술래가 바뀌며 그사람 횟수 추가
				char tmp = tagger;
				
				numPlayer[ players[start]-'A' ]++;
				tagger = players[start];
				players[start] = tmp;
			}
		}
	}
	for(int i=0;i<players.size();i++){
		cout<<players[i]<<" "<<numPlayer[ players[i] - 'A']<<endl;
	}
	cout<<tagger<<" "<<numPlayer[ tagger - 'A']<<endl;
}

struct input_data {
  int numOfAllPlayers;
  int numOfQuickPlayers;
  char *namesOfQuickPlayers;
  int numOfGames;
  int *numOfMovesPerGame;
};

void process_stdin(struct input_data& inputData) {
  string line;
  istringstream iss;

  getline(cin, line);
  iss.str(line);
  iss >> inputData.numOfAllPlayers;

  getline(cin, line);
  iss.clear();
  iss.str(line);
  iss >> inputData.numOfQuickPlayers;

  getline(cin, line);
  iss.clear();
  iss.str(line);
  inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
  for (int i = 0; i < inputData.numOfQuickPlayers; i++) {
    iss >> inputData.namesOfQuickPlayers[i];
  }

  getline(cin, line);
  iss.clear();
  iss.str(line);
  iss >> inputData.numOfGames;

  getline(cin, line);
  iss.clear();
  iss.str(line);
  inputData.numOfMovesPerGame = new int[inputData.numOfGames];
  for (int i = 0; i < inputData.numOfGames; i++) {
    iss >> inputData.numOfMovesPerGame[i];
  }
}

int main() {
  struct input_data inputData;
  process_stdin(inputData);

  solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
  return 0;
}