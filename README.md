# Readable Code

### step 1: 추상

**도메인 용어 정리**

- `board`: 게임판
- `landMine`: 지뢰
- `gameStatus`: 게임 진행 상태


**이름 짓기**

- (가로, 세로) -> (`row`, `col`)
- 좌표 입력 -> `cellInput`
- 입력된 (가로, 세로) -> (`cellInputCol`, `cellInputRow`)
- 입력된 값의 좌표상 값 -> (`selectedColIndex`, `selectedRowIndex`)
- 수행할 행위 입력 -> `userActionInput`


**메서드 추상화**

- 안내 문구 출력 메서드 -> `showGameStartComments()`
- 게임 세팅 초기화 -> `initializeGame()`
- 게임판 출력 -> `showBoard()`
- 입력된 col 값을 실제 좌표 상의 값으로 변환 -> `converColFrom(char cellInputCol)`
- 입력된 row 값을 실제 좌표 상의 값으로 변환 -> `converRowFrom(int cellInputRow)`
- 게임이 끝났는지 체크 -> `checkIfGameIsOver()`
  - 셀이 전부 열렸는지 체크 -> `isAllCellOpened()`
  -
