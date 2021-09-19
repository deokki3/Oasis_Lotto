## **프로그래밍 요구사항**

- **모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외**
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - switch/case도 허용하지 않는다.

## **기능 목록 및 commit 로그 요구사항**

- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

## ** 구현할 기능**
 InputView{
- 구입할 금액입력
- 당첨번호 입력
 }
 ResultView{
- 금액에 따른 로또 개수 출력
- 로또 개수 만큼의 로또 티켓 출력
- 당첨 통계
- 당첨 개수 & 수익률 출력
 }
 LottoTicketMaker{

- 로또 넘버 6개 생성(1~45)
- 로또 티켓 개수만큼 생성
- 한장당 가격 1000원 설정
 }
 PrizeCalculator{
- 당첨시 수익률 계산
 }
 WinningTicketor{
- 당첨 번호 구별 
- 당첨개수 카운트
- 당첨 통계 put
 }

