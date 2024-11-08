# Readable Code

### step 1: 추상

**도메인 용어 정리**

- board: 게임판
- landMine: 지뢰
- gameStatus: 게임 진행 상태


**이름 짓기**

- (가로, 세로) -> (row, col)
- 좌표 입력 -> cellInput
- 입력된 (가로, 세로) -> (cellInputRow, cellInputCol)
- 입력된 값의 좌표상 값 -> (selectedRowIndex, selectedColIndex)
- 수행할 행위 입력 -> userActionInput
- 모든 좌표가 열렸는지 체크하는 boolean -> isAllOpened
-
