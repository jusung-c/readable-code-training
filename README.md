# Readable Code

### step 1: 추상

**도메인 용어 정리**

- `board`: 게임판
- `landMine`: 지뢰
- `gameStatus`: 게임 진행 상태

**이름 짓기**

- (가로, 세로): (`row`, `col`)
- 좌표 입력: `cellInput`
- 입력된 (가로, 세로): (`cellInputCol`, `cellInputRow`)
- 입력된 값의 좌표상 값: (`selectedColIndex`, `selectedRowIndex`)
- 수행할 행위 입력: `userActionInput`

**메서드 추상화하기 (추상화 레벨 맞추기)**

- 안내 문구 출력 메서드: `showGameStartComments()`
- 게임 세팅 초기화: `initializeGame()`
- 게임판 출력: `showBoard()`
- 입력된 col 값을 실제 좌표 상의 값으로 변환: `converColFrom(char cellInputCol)`
- 입력된 row 값을 실제 좌표 상의 값으로 변환: `converRowFrom(int cellInputRow)`
- 게임이 끝났는지 체크: `checkIfGameIsOver()`
  - 셀이 전부 열렸는지 체크: `isAllCellOpened()`
- 지뢰를 모두 찾았는가?: `doesUserWinTheGame()`
- 지뢰를 밟았는가?: `doesUserLoseTheGame()`
- 유저에게 좌표 입력 받기: `getCellInputFromUser()`
- 유저에게 행위 입력 받기: `getActionInputFromUser()`
- 입력으로부터 실제 좌표값 얻기: `getSelectedRowIndex()`,`getSelectedColIndex()`
- 사용자가 깃발을 선택했는가?: `doesUserChooseToPlantFlag()`
- 사용자가 오픈을 선택했는가?: `doesUserChooseToOpenCell()`
- 선택한 셀이 지뢰인가?: `isLandMineCell()`
- 지뢰를 밟은 경우 게임 상태 변경: `changeGameStatusToLose()`
- 전부 오픈한 경우 게임 상태 변경: `changeGameStatusToWin()`

**상수 추출하기**

- board, landMineCounts, landMines 배열은 그 자체의 값은 변하지 않으므로 상수
  - 그 안의 값이 바뀌는 것
  - gameStatus는 값이 변하므로 X
- `static final 반환타입 대문자상수명`
- `BOARD`, `NEARBY_LAND_MINE_COUNTS`, `LAND_MINES`
- 게임판의 가로 세로 길이도 자주 사용되므로 상수로 추출: `BOARD_ROW_SIZE, `BOARD_COL_SIZE`
  - 상수로 변환할 때 로직 체크 필수. 같은 값인데 의미가 다른 경우 주의
- 지뢰 개수: `LAND_MINE_COUNT`
- 셀의 4가지 상태: `FLAG_SIGN`, `LANE_MINE_SIGN`, `CLOSED_CELL_SIGN`, `OPENED_CELL_SIGN`



### step 2: 사고의 흐름이 자연스럽도록 개선

**Early return**

1. 메서드로 추출
2. if문 빠르게 return해서 else문 없애기


**depth 줄이기**

- 메서드 분리를 통해 중첩문의 depth를 줄인다.
- 사고의 depth를 줄이는 것에 집중할 것. 무조건 depth를 줄이려고 메서드 쪼개기만 한다면 더 복잡해질 것.

  - 이번 도메인의 경우 row와 col은 항상 이중 포문으로 같이 사용되기 때문에 depth를 줄이겠다고 메서드 분리를 하면 더 복잡해진다.
- tip) 메서드 리팩토링 시에는 메서드 복제 후 하는 것이 컴파일 에러를 최소화하면서 할 수 있다.

  - 메서드 복제 -> 메서드 리팩토링 -> 사용되는 곳에서 리팩토링 한 메서드로 대체해보기 -> 전부 대체 가능하면 기존 메서드 삭제 -> 리팩토링한 메서드명 기존 메서드명으로 변경
- 2중 for문으로 row, col을 접근하는 것은 게임판 전체에 접근하고 싶다는 의미: stream으로 모든 원소에 접근하는 방식으로 개선

  ```
              Arrays.stream(BOARD)
                  .flatMap(Arrays::stream)
                  // ...
  ```
- 사용할 변수는 가깝게 선언하자

  - 자주 사용되고, 무거운 변수는 상수로 빼는 것도 고려해보자
- 공백을 통해 논리의 흐름을 끊어주자
